/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UBD;

import UBD.exceptions.NonexistentEntityException;
import UBD.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import UML.Clientes;
import UML.Abogados;
import UML.Casos;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author v6222
 */
public class CasosJpaController implements Serializable {

    public CasosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Casos casos) throws PreexistingEntityException, Exception {
        if (casos.getAbogadosList() == null) {
            casos.setAbogadosList(new ArrayList<Abogados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes clientedni = casos.getClientedni();
            if (clientedni != null) {
                clientedni = em.getReference(clientedni.getClass(), clientedni.getDni());
                casos.setClientedni(clientedni);
            }
            List<Abogados> attachedAbogadosList = new ArrayList<Abogados>();
            for (Abogados abogadosListAbogadosToAttach : casos.getAbogadosList()) {
                abogadosListAbogadosToAttach = em.getReference(abogadosListAbogadosToAttach.getClass(), abogadosListAbogadosToAttach.getDni());
                attachedAbogadosList.add(abogadosListAbogadosToAttach);
            }
            casos.setAbogadosList(attachedAbogadosList);
            em.persist(casos);
            if (clientedni != null) {
                clientedni.getCasosList().add(casos);
                clientedni = em.merge(clientedni);
            }
            for (Abogados abogadosListAbogados : casos.getAbogadosList()) {
                abogadosListAbogados.getCasosList().add(casos);
                abogadosListAbogados = em.merge(abogadosListAbogados);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCasos(casos.getNumExp()) != null) {
                throw new PreexistingEntityException("Casos " + casos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Casos casos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Casos persistentCasos = em.find(Casos.class, casos.getNumExp());
            Clientes clientedniOld = persistentCasos.getClientedni();
            Clientes clientedniNew = casos.getClientedni();
            List<Abogados> abogadosListOld = persistentCasos.getAbogadosList();
            List<Abogados> abogadosListNew = casos.getAbogadosList();
            if (clientedniNew != null) {
                clientedniNew = em.getReference(clientedniNew.getClass(), clientedniNew.getDni());
                casos.setClientedni(clientedniNew);
            }
            List<Abogados> attachedAbogadosListNew = new ArrayList<Abogados>();
            for (Abogados abogadosListNewAbogadosToAttach : abogadosListNew) {
                abogadosListNewAbogadosToAttach = em.getReference(abogadosListNewAbogadosToAttach.getClass(), abogadosListNewAbogadosToAttach.getDni());
                attachedAbogadosListNew.add(abogadosListNewAbogadosToAttach);
            }
            abogadosListNew = attachedAbogadosListNew;
            casos.setAbogadosList(abogadosListNew);
            casos = em.merge(casos);
            if (clientedniOld != null && !clientedniOld.equals(clientedniNew)) {
                clientedniOld.getCasosList().remove(casos);
                clientedniOld = em.merge(clientedniOld);
            }
            if (clientedniNew != null && !clientedniNew.equals(clientedniOld)) {
                clientedniNew.getCasosList().add(casos);
                clientedniNew = em.merge(clientedniNew);
            }
            for (Abogados abogadosListOldAbogados : abogadosListOld) {
                if (!abogadosListNew.contains(abogadosListOldAbogados)) {
                    abogadosListOldAbogados.getCasosList().remove(casos);
                    abogadosListOldAbogados = em.merge(abogadosListOldAbogados);
                }
            }
            for (Abogados abogadosListNewAbogados : abogadosListNew) {
                if (!abogadosListOld.contains(abogadosListNewAbogados)) {
                    abogadosListNewAbogados.getCasosList().add(casos);
                    abogadosListNewAbogados = em.merge(abogadosListNewAbogados);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = casos.getNumExp();
                if (findCasos(id) == null) {
                    throw new NonexistentEntityException("The casos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Casos casos;
            try {
                casos = em.getReference(Casos.class, id);
                casos.getNumExp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The casos with id " + id + " no longer exists.", enfe);
            }
            Clientes clientedni = casos.getClientedni();
            if (clientedni != null) {
                clientedni.getCasosList().remove(casos);
                clientedni = em.merge(clientedni);
            }
            List<Abogados> abogadosList = casos.getAbogadosList();
            for (Abogados abogadosListAbogados : abogadosList) {
                abogadosListAbogados.getCasosList().remove(casos);
                abogadosListAbogados = em.merge(abogadosListAbogados);
            }
            em.remove(casos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Casos> findCasosEntities() {
        return findCasosEntities(true, -1, -1);
    }

    public List<Casos> findCasosEntities(int maxResults, int firstResult) {
        return findCasosEntities(false, maxResults, firstResult);
    }

    private List<Casos> findCasosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Casos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Casos findCasos(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Casos.class, id);
        } finally {
            em.close();
        }
    }

    public int getCasosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Casos> rt = cq.from(Casos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
