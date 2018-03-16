/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UBD;

import UBD.exceptions.NonexistentEntityException;
import UBD.exceptions.PreexistingEntityException;
import UML.Abogados;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import UML.Casos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author v6222
 */
public class AbogadosJpaController implements Serializable {

    public AbogadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Abogados abogados) throws PreexistingEntityException, Exception {
        if (abogados.getCasosCollection() == null) {
            abogados.setCasosCollection(new ArrayList<Casos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Casos> attachedCasosCollection = new ArrayList<Casos>();
            for (Casos casosCollectionCasosToAttach : abogados.getCasosCollection()) {
                casosCollectionCasosToAttach = em.getReference(casosCollectionCasosToAttach.getClass(), casosCollectionCasosToAttach.getNumExp());
                attachedCasosCollection.add(casosCollectionCasosToAttach);
            }
            abogados.setCasosCollection(attachedCasosCollection);
            em.persist(abogados);
            for (Casos casosCollectionCasos : abogados.getCasosCollection()) {
                casosCollectionCasos.getAbogadosCollection().add(abogados);
                casosCollectionCasos = em.merge(casosCollectionCasos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAbogados(abogados.getDni()) != null) {
                throw new PreexistingEntityException("Abogados " + abogados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Abogados abogados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Abogados persistentAbogados = em.find(Abogados.class, abogados.getDni());
            Collection<Casos> casosCollectionOld = persistentAbogados.getCasosCollection();
            Collection<Casos> casosCollectionNew = abogados.getCasosCollection();
            Collection<Casos> attachedCasosCollectionNew = new ArrayList<Casos>();
            for (Casos casosCollectionNewCasosToAttach : casosCollectionNew) {
                casosCollectionNewCasosToAttach = em.getReference(casosCollectionNewCasosToAttach.getClass(), casosCollectionNewCasosToAttach.getNumExp());
                attachedCasosCollectionNew.add(casosCollectionNewCasosToAttach);
            }
            casosCollectionNew = attachedCasosCollectionNew;
            abogados.setCasosCollection(casosCollectionNew);
            abogados = em.merge(abogados);
            for (Casos casosCollectionOldCasos : casosCollectionOld) {
                if (!casosCollectionNew.contains(casosCollectionOldCasos)) {
                    casosCollectionOldCasos.getAbogadosCollection().remove(abogados);
                    casosCollectionOldCasos = em.merge(casosCollectionOldCasos);
                }
            }
            for (Casos casosCollectionNewCasos : casosCollectionNew) {
                if (!casosCollectionOld.contains(casosCollectionNewCasos)) {
                    casosCollectionNewCasos.getAbogadosCollection().add(abogados);
                    casosCollectionNewCasos = em.merge(casosCollectionNewCasos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = abogados.getDni();
                if (findAbogados(id) == null) {
                    throw new NonexistentEntityException("The abogados with id " + id + " no longer exists.");
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
            Abogados abogados;
            try {
                abogados = em.getReference(Abogados.class, id);
                abogados.getDni();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The abogados with id " + id + " no longer exists.", enfe);
            }
            Collection<Casos> casosCollection = abogados.getCasosCollection();
            for (Casos casosCollectionCasos : casosCollection) {
                casosCollectionCasos.getAbogadosCollection().remove(abogados);
                casosCollectionCasos = em.merge(casosCollectionCasos);
            }
            em.remove(abogados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Abogados> findAbogadosEntities() {
        return findAbogadosEntities(true, -1, -1);
    }

    public List<Abogados> findAbogadosEntities(int maxResults, int firstResult) {
        return findAbogadosEntities(false, maxResults, firstResult);
    }

    private List<Abogados> findAbogadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Abogados.class));
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

    public Abogados findAbogados(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Abogados.class, id);
        } finally {
            em.close();
        }
    }

    public int getAbogadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Abogados> rt = cq.from(Abogados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
