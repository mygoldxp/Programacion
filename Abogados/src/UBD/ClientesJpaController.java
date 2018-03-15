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
import java.util.Collection;
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
        if (clientes.getCasosCollection() == null) {
            clientes.setCasosCollection(new ArrayList<Casos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Casos> attachedCasosCollection = new ArrayList<Casos>();
            for (Casos casosCollectionCasosToAttach : clientes.getCasosCollection()) {
                casosCollectionCasosToAttach = em.getReference(casosCollectionCasosToAttach.getClass(), casosCollectionCasosToAttach.getNumExp());
                attachedCasosCollection.add(casosCollectionCasosToAttach);
            }
            clientes.setCasosCollection(attachedCasosCollection);
            em.persist(clientes);
            for (Casos casosCollectionCasos : clientes.getCasosCollection()) {
                Clientes oldClientedniOfCasosCollectionCasos = casosCollectionCasos.getClientedni();
                casosCollectionCasos.setClientedni(clientes);
                casosCollectionCasos = em.merge(casosCollectionCasos);
                if (oldClientedniOfCasosCollectionCasos != null) {
                    oldClientedniOfCasosCollectionCasos.getCasosCollection().remove(casosCollectionCasos);
                    oldClientedniOfCasosCollectionCasos = em.merge(oldClientedniOfCasosCollectionCasos);
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
            Collection<Casos> casosCollectionOld = persistentClientes.getCasosCollection();
            Collection<Casos> casosCollectionNew = clientes.getCasosCollection();
            List<String> illegalOrphanMessages = null;
            for (Casos casosCollectionOldCasos : casosCollectionOld) {
                if (!casosCollectionNew.contains(casosCollectionOldCasos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Casos " + casosCollectionOldCasos + " since its clientedni field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Casos> attachedCasosCollectionNew = new ArrayList<Casos>();
            for (Casos casosCollectionNewCasosToAttach : casosCollectionNew) {
                casosCollectionNewCasosToAttach = em.getReference(casosCollectionNewCasosToAttach.getClass(), casosCollectionNewCasosToAttach.getNumExp());
                attachedCasosCollectionNew.add(casosCollectionNewCasosToAttach);
            }
            casosCollectionNew = attachedCasosCollectionNew;
            clientes.setCasosCollection(casosCollectionNew);
            clientes = em.merge(clientes);
            for (Casos casosCollectionNewCasos : casosCollectionNew) {
                if (!casosCollectionOld.contains(casosCollectionNewCasos)) {
                    Clientes oldClientedniOfCasosCollectionNewCasos = casosCollectionNewCasos.getClientedni();
                    casosCollectionNewCasos.setClientedni(clientes);
                    casosCollectionNewCasos = em.merge(casosCollectionNewCasos);
                    if (oldClientedniOfCasosCollectionNewCasos != null && !oldClientedniOfCasosCollectionNewCasos.equals(clientes)) {
                        oldClientedniOfCasosCollectionNewCasos.getCasosCollection().remove(casosCollectionNewCasos);
                        oldClientedniOfCasosCollectionNewCasos = em.merge(oldClientedniOfCasosCollectionNewCasos);
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
            Collection<Casos> casosCollectionOrphanCheck = clientes.getCasosCollection();
            for (Casos casosCollectionOrphanCheckCasos : casosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Clientes (" + clientes + ") cannot be destroyed since the Casos " + casosCollectionOrphanCheckCasos + " in its casosCollection field has a non-nullable clientedni field.");
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
