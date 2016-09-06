/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import bl.exceptions.NonexistentEntityException;
import dl.Deportista;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dl.MAntropometricas;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author desarrolloPC
 */
public class DeportistaJpaController implements Serializable {

    public DeportistaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Deportista deportista) {
        if (deportista.getMAntropometricasList() == null) {
            deportista.setMAntropometricasList(new ArrayList<MAntropometricas>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<MAntropometricas> attachedMAntropometricasList = new ArrayList<MAntropometricas>();
            for (MAntropometricas MAntropometricasListMAntropometricasToAttach : deportista.getMAntropometricasList()) {
                MAntropometricasListMAntropometricasToAttach = em.getReference(MAntropometricasListMAntropometricasToAttach.getClass(), MAntropometricasListMAntropometricasToAttach.getIdMAntropomrtricas());
                attachedMAntropometricasList.add(MAntropometricasListMAntropometricasToAttach);
            }
            deportista.setMAntropometricasList(attachedMAntropometricasList);
            em.persist(deportista);
            for (MAntropometricas MAntropometricasListMAntropometricas : deportista.getMAntropometricasList()) {
                Deportista oldIdDeportistaOfMAntropometricasListMAntropometricas = MAntropometricasListMAntropometricas.getIdDeportista();
                MAntropometricasListMAntropometricas.setIdDeportista(deportista);
                MAntropometricasListMAntropometricas = em.merge(MAntropometricasListMAntropometricas);
                if (oldIdDeportistaOfMAntropometricasListMAntropometricas != null) {
                    oldIdDeportistaOfMAntropometricasListMAntropometricas.getMAntropometricasList().remove(MAntropometricasListMAntropometricas);
                    oldIdDeportistaOfMAntropometricasListMAntropometricas = em.merge(oldIdDeportistaOfMAntropometricasListMAntropometricas);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Deportista deportista) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Deportista persistentDeportista = em.find(Deportista.class, deportista.getIdDeportista());
            List<MAntropometricas> MAntropometricasListOld = persistentDeportista.getMAntropometricasList();
            List<MAntropometricas> MAntropometricasListNew = deportista.getMAntropometricasList();
            List<MAntropometricas> attachedMAntropometricasListNew = new ArrayList<MAntropometricas>();
            for (MAntropometricas MAntropometricasListNewMAntropometricasToAttach : MAntropometricasListNew) {
                MAntropometricasListNewMAntropometricasToAttach = em.getReference(MAntropometricasListNewMAntropometricasToAttach.getClass(), MAntropometricasListNewMAntropometricasToAttach.getIdMAntropomrtricas());
                attachedMAntropometricasListNew.add(MAntropometricasListNewMAntropometricasToAttach);
            }
            MAntropometricasListNew = attachedMAntropometricasListNew;
            deportista.setMAntropometricasList(MAntropometricasListNew);
            deportista = em.merge(deportista);
            for (MAntropometricas MAntropometricasListOldMAntropometricas : MAntropometricasListOld) {
                if (!MAntropometricasListNew.contains(MAntropometricasListOldMAntropometricas)) {
                    MAntropometricasListOldMAntropometricas.setIdDeportista(null);
                    MAntropometricasListOldMAntropometricas = em.merge(MAntropometricasListOldMAntropometricas);
                }
            }
            for (MAntropometricas MAntropometricasListNewMAntropometricas : MAntropometricasListNew) {
                if (!MAntropometricasListOld.contains(MAntropometricasListNewMAntropometricas)) {
                    Deportista oldIdDeportistaOfMAntropometricasListNewMAntropometricas = MAntropometricasListNewMAntropometricas.getIdDeportista();
                    MAntropometricasListNewMAntropometricas.setIdDeportista(deportista);
                    MAntropometricasListNewMAntropometricas = em.merge(MAntropometricasListNewMAntropometricas);
                    if (oldIdDeportistaOfMAntropometricasListNewMAntropometricas != null && !oldIdDeportistaOfMAntropometricasListNewMAntropometricas.equals(deportista)) {
                        oldIdDeportistaOfMAntropometricasListNewMAntropometricas.getMAntropometricasList().remove(MAntropometricasListNewMAntropometricas);
                        oldIdDeportistaOfMAntropometricasListNewMAntropometricas = em.merge(oldIdDeportistaOfMAntropometricasListNewMAntropometricas);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = deportista.getIdDeportista();
                if (findDeportista(id) == null) {
                    throw new NonexistentEntityException("The deportista with id " + id + " no longer exists.");
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
            Deportista deportista;
            try {
                deportista = em.getReference(Deportista.class, id);
                deportista.getIdDeportista();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The deportista with id " + id + " no longer exists.", enfe);
            }
            List<MAntropometricas> MAntropometricasList = deportista.getMAntropometricasList();
            for (MAntropometricas MAntropometricasListMAntropometricas : MAntropometricasList) {
                MAntropometricasListMAntropometricas.setIdDeportista(null);
                MAntropometricasListMAntropometricas = em.merge(MAntropometricasListMAntropometricas);
            }
            em.remove(deportista);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Deportista> findDeportistaEntities() {
        return findDeportistaEntities(true, -1, -1);
    }

    public List<Deportista> findDeportistaEntities(int maxResults, int firstResult) {
        return findDeportistaEntities(false, maxResults, firstResult);
    }

    private List<Deportista> findDeportistaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Deportista.class));
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

    public Deportista findDeportista(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Deportista.class, id);
        } finally {
            em.close();
        }
    }

    public int getDeportistaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Deportista> rt = cq.from(Deportista.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
