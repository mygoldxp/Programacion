/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UBD;

import UBD.exceptions.IllegalOrphanException;
import UBD.exceptions.NonexistentEntityException;
import UBD.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import UML.Casos;
import UML.Clientes;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author v6222
 */
public class ClientesJpaController implements Serializable {

    public ClientesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Clientes clientes) throws PreexistingEntityException, Exception {
        if (clientes.getCasosList() == null) {
            clientes.setCasosList(new ArrayList<Casos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Casos> attachedCasosList = new ArrayList<Casos>();
            for (Casos casosListCasosToAttach : clientes.getCasosList()) {
                casosListCasosToAttach = em.getReference(casosListCasosToAttach.getClass(), casosListCasosToAttach.getNumExp());
                attachedCasosList.add(casosListCasosToAttach);
            }
            clientes.setCasosList(attachedCasosList);
            em.persist(clientes);
            for (Casos casosListCasos : clientes.getCasosList()) {
                Clientes oldClientedniOfCasosListCasos = casosListCasos.getClientedni();
                casosListCasos.setClientedni(clientes);
                casosListCasos = em.merge(casosListCasos);
                if (oldClientedniOfCasosListCasos != null) {
                    oldClientedniOfCasosListCasos.getCasosList().remove(casosListCasos);
                    oldClientedniOfCasosListCasos = em.merge(oldClientedniOfCasosListCasos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClientes(clientes.getDni()) != null) {
                throw new PreexistingEntityException("Clientes " + clientes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Clientes clientes) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes persistentClientes = em.find(Clientes.class, clientes.getDni());
            List<Casos> casosListOld = persistentClientes.getCasosList();
            List<Casos> casosListNew = clientes.getCasosList();
            List<String> illegalOrphanMessages = null;
            for (Casos casosListOldCasos : casosListOld) {
                if (!casosListNew.contains(casosListOldCasos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Casos " + casosListOldCasos + " since its clientedni field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Casos> attachedCasosListNew = new ArrayList<Casos>();
            for (Casos casosListNewCasosToAttach : casosListNew) {
                casosListNewCasosToAttach = em.getReference(casosListNewCasosToAttach.getClass(), casosListNewCasosToAttach.getNumExp());
                attachedCasosListNew.add(casosListNewCasosToAttach);
            }
            casosListNew = attachedCasosListNew;
            clientes.setCasosList(casosListNew);
            clientes = em.merge(clientes);
            for (Casos casosListNewCasos : casosListNew) {
                if (!casosListOld.contains(casosListNewCasos)) {
                    Clientes oldClientedniOfCasosListNewCasos = casosListNewCasos.getClientedni();
                    casosListNewCasos.setClientedni(clientes);
                    casosListNewCasos = em.merge(casosListNewCasos);
                    if (oldClientedniOfCasosListNewCasos != null && !oldClientedniOfCasosListNewCasos.equals(clientes)) {
                        oldClientedniOfCasosListNewCasos.getCasosList().remove(casosListNewCasos);
                        oldClientedniOfCasosListNewCasos = em.merge(oldClientedniOfCasosListNewCasos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = clientes.getDni();
                if (findClientes(id) == null) {
                    throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes clientes;
            try {
                clientes = em.getReference(Clientes.class, id);
                clientes.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The clientes with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Casos> casosListOrphanCheck = clientes.getCasosList();
            for (Casos casosListOrphanCheckCasos : casosListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Clientes (" + clientes + ") cannot be destroyed since the Casos " + casosListOrphanCheckCasos + " in its casosList field has a non-nullable clientedni field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(clientes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Clientes> findClientesEntities() {
        return findClientesEntities(true, -1, -1);
    }

    public List<Clientes> findClientesEntities(int maxResults, int firstResult) {
        return findClientesEntities(false, maxResults, firstResult);
    }

    private List<Clientes> findClientesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Clientes.class));
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

    public Clientes findClientes(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Clientes.class, id);
        } finally {
            em.close();
        }
    }

    public int getClientesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Clientes> rt = cq.from(Clientes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
