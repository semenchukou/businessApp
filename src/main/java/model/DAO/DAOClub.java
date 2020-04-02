package model.DAO;

import model.entities.Club;
import model.exceptions.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class DAOClub extends DAO {

    public DAOClub() throws DAOException {
        super();
    }

    public List<Club> getAllClubs() throws DAOException {
        EntityManager entityManager = null;
        List<Club> clubs = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Club> cq = cb.createQuery(Club.class);
            Root<Club> club = cq.from(Club.class);
            cq.select(club);
            TypedQuery<Club> q = entityManager.createQuery(cq);
            clubs = q.getResultList();
        } catch (Exception e) {
            throw new DAOException("Failed to get all clubs", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return clubs;
    }

    public Club getClubByID(int id) throws DAOException {
        EntityManager entityManager = null;
        Club club = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Club> cq = cb.createQuery(Club.class);
            Root<Club> cl = cq.from(Club.class);
            cq.select(cl).where(cb.equal(cl.get("idClub"), id));
            TypedQuery<Club> q = entityManager.createQuery(cq);
            club = q.getSingleResult();
        } catch (Exception e) {
            throw new DAOException("Failed while getting club", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return club;
    }

    public void insertClub(Club club) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(club);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("Failed while inserting", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    public void deleteClub(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaDelete<Club> delete = cb.
                    createCriteriaDelete(Club.class);
            Root e = delete.from(Club.class);
            delete.where(cb.equal(e.get("idClub"), id));
            entityManager.getTransaction().begin();
            entityManager.createQuery(delete).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("Failed while deleting", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }

    public void updateClub(Club club, int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaUpdate<Club> update = cb.
                    createCriteriaUpdate(Club.class);
            Root e = update.from(Club.class);
            update.set("name", club.getName());
            update.set("foundation_year", club.getFoundation_year());
            update.set("coach", club.getCoach());
            update.where(cb.equal(e.get("idClub"), id));

            entityManager.getTransaction().begin();
            entityManager.createQuery(update).executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive())
                transaction.rollback();
            throw new DAOException("Failed while deleting", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
    }
}
