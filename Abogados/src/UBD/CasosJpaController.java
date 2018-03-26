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
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

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
        if (casos.getAbogadosCollection() == null) {
            casos.setAbogadosCollection(new ArrayList<Abogados>());
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
            Collection<Abogados> attachedAbogadosCollection = new ArrayList<Abogados>();
            for (Abogados abogadosCollectionAbogadosToAttach : casos.getAbogadosCollection()) {
                abogadosCollectionAbogadosToAttach = em.getReference(abogadosCollectionAbogadosToAttach.getClass(), abogadosCollectionAbogadosToAttach.getDni());
                attachedAbogadosCollection.add(abogadosCollectionAbogadosToAttach);
            }
            casos.setAbogadosCollection(attachedAbogadosCollection);
            em.persist(casos);
            if (clientedni != null) {
                clientedni.getCasosCollection().add(casos);
                clientedni = em.merge(clientedni);
            }
            for (Abogados abogadosCollectionAbogados : casos.getAbogadosCollection()) {
                abogadosCollectionAbogados.getCasosCollection().add(casos);
                abogadosCollectionAbogados = em.merge(abogadosCollectionAbogados);
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

    /*
    public void editar(Casos caso){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.merge(caso);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getClass());
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    */
    
    public void edit(Casos casos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Casos persistentCasos = em.find(Casos.class, casos.getNumExp());
            Clientes clientedniOld = persistentCasos.getClientedni();
            Clientes clientedniNew = casos.getClientedni();
            Collection<Abogados> abogadosCollectionOld = persistentCasos.getAbogadosCollection();
            Collection<Abogados> abogadosCollectionNew = casos.getAbogadosCollection();
            if (clientedniNew != null) {
                clientedniNew = em.getReference(clientedniNew.getClass(), clientedniNew.getDni());
                casos.setClientedni(clientedniNew);
            }
            Collection<Abogados> attachedAbogadosCollectionNew = new ArrayList<Abogados>();
            for (Abogados abogadosCollectionNewAbogadosToAttach : abogadosCollectionNew) {
                abogadosCollectionNewAbogadosToAttach = em.getReference(abogadosCollectionNewAbogadosToAttach.getClass(), abogadosCollectionNewAbogadosToAttach.getDni());
                attachedAbogadosCollectionNew.add(abogadosCollectionNewAbogadosToAttach);
            }
            abogadosCollectionNew = attachedAbogadosCollectionNew;
            casos.setAbogadosCollection(abogadosCollectionNew);
            casos = em.merge(casos);
            if (clientedniOld != null && !clientedniOld.equals(clientedniNew)) {
                clientedniOld.getCasosCollection().remove(casos);
                clientedniOld = em.merge(clientedniOld);
            }
            if (clientedniNew != null && !clientedniNew.equals(clientedniOld)) {
                clientedniNew.getCasosCollection().add(casos);
                clientedniNew = em.merge(clientedniNew);
            }
            for (Abogados abogadosCollectionOldAbogados : abogadosCollectionOld) {
                if (!abogadosCollectionNew.contains(abogadosCollectionOldAbogados)) {
                    abogadosCollectionOldAbogados.getCasosCollection().remove(casos);
                    abogadosCollectionOldAbogados = em.merge(abogadosCollectionOldAbogados);
                }
            }
            for (Abogados abogadosCollectionNewAbogados : abogadosCollectionNew) {
                if (!abogadosCollectionOld.contains(abogadosCollectionNewAbogados)) {
                    abogadosCollectionNewAbogados.getCasosCollection().add(casos);
                    abogadosCollectionNewAbogados = em.merge(abogadosCollectionNewAbogados);
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
                clientedni.getCasosCollection().remove(casos);
                clientedni = em.merge(clientedni);
            }
            Collection<Abogados> abogadosCollection = casos.getAbogadosCollection();
            for (Abogados abogadosCollectionAbogados : abogadosCollection) {
                abogadosCollectionAbogados.getCasosCollection().remove(casos);
                abogadosCollectionAbogados = em.merge(abogadosCollectionAbogados);
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
    
    public ArrayList<Casos> buscarListaCasos(Casos caso) throws Exception {

        EntityManager em = getEntityManager();
        ArrayList <Casos> listaCaso = new ArrayList(); 
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Casos.class));
            Query q = em.createQuery("SELECT a FROM Casos a WHERE a.numExp like :exp and a.estado like :estado");
            q.setParameter("exp", "%" + caso.getNumExp()+ "%");
            q.setParameter("estado", "%" + caso.getEstado()+ "%");
                        
            List <Casos> results = q.getResultList();
            
            for(Casos ab:results){
                listaCaso.add(ab);
            }
            
            return listaCaso;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
