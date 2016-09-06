/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import bl.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dl.Deportista;
import dl.MAntropometricas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author desarrolloPC
 */
public class MAntropometricasJpaController implements Serializable {

    public MAntropometricasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MAntropometricas MAntropometricas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Deportista idDeportista = MAntropometricas.getIdDeportista();
            if (idDeportista != null) {
                idDeportista = em.getReference(idDeportista.getClass(), idDeportista.getIdDeportista());
                MAntropometricas.setIdDeportista(idDeportista);
            }
            em.persist(MAntropometricas);
            if (idDeportista != null) {
                idDeportista.getMAntropometricasList().add(MAntropometricas);
                idDeportista = em.merge(idDeportista);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MAntropometricas MAntropometricas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MAntropometricas persistentMAntropometricas = em.find(MAntropometricas.class, MAntropometricas.getIdMAntropomrtricas());
            Deportista idDeportistaOld = persistentMAntropometricas.getIdDeportista();
            Deportista idDeportistaNew = MAntropometricas.getIdDeportista();
            if (idDeportistaNew != null) {
                idDeportistaNew = em.getReference(idDeportistaNew.getClass(), idDeportistaNew.getIdDeportista());
                MAntropometricas.setIdDeportista(idDeportistaNew);
            }
            MAntropometricas = em.merge(MAntropometricas);
            if (idDeportistaOld != null && !idDeportistaOld.equals(idDeportistaNew)) {
                idDeportistaOld.getMAntropometricasList().remove(MAntropometricas);
                idDeportistaOld = em.merge(idDeportistaOld);
            }
            if (idDeportistaNew != null && !idDeportistaNew.equals(idDeportistaOld)) {
                idDeportistaNew.getMAntropometricasList().add(MAntropometricas);
                idDeportistaNew = em.merge(idDeportistaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = MAntropometricas.getIdMAntropomrtricas();
                if (findMAntropometricas(id) == null) {
                    throw new NonexistentEntityException("The mAntropometricas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MAntropometricas MAntropometricas;
            try {
                MAntropometricas = em.getReference(MAntropometricas.class, id);
                MAntropometricas.getIdMAntropomrtricas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The MAntropometricas with id " + id + " no longer exists.", enfe);
            }
            Deportista idDeportista = MAntropometricas.getIdDeportista();
            if (idDeportista != null) {
                idDeportista.getMAntropometricasList().remove(MAntropometricas);
                idDeportista = em.merge(idDeportista);
            }
            em.remove(MAntropometricas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MAntropometricas> findMAntropometricasEntities() {
        return findMAntropometricasEntities(true, -1, -1);
    }

    public List<MAntropometricas> findMAntropometricasEntities(int maxResults, int firstResult) {
        return findMAntropometricasEntities(false, maxResults, firstResult);
    }

    private List<MAntropometricas> findMAntropometricasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MAntropometricas.class));
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

    public MAntropometricas findMAntropometricas(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MAntropometricas.class, id);
        } finally {
            em.close();
        }
    }

    public int getMAntropometricasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MAntropometricas> rt = cq.from(MAntropometricas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
