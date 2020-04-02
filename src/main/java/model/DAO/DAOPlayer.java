package model.DAO;

import model.entities.Club;
import model.entities.Player;
import model.exceptions.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

public class DAOPlayer extends DAO {

    public DAOPlayer() throws DAOException {
        super();
    }

    public List<Player> getAllPlayers() throws DAOException {
        EntityManager entityManager = null;
        List<Player> players = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Player> cq = cb.createQuery(Player.class);
            Root<Player> player = cq.from(Player.class);
            cq.select(player);
            TypedQuery<Player> q = entityManager.createQuery(cq);
            players = q.getResultList();
        } catch (Exception e) {
            throw new DAOException("Failed to get all players", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return players;
    }

    public Player getPlayerByID(int id) throws DAOException {
        EntityManager entityManager = null;
        Player player = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Player> cq = cb.createQuery(Player.class);
            Root<Player> cl = cq.from(Player.class);
            cq.select(cl).where(cb.equal(cl.get("idPlayers"), id));
            TypedQuery<Player> q = entityManager.createQuery(cq);
            player = q.getSingleResult();
        } catch (Exception e) {
            throw new DAOException("Failed while getting player", e);
        } finally {
            if (entityManager != null && entityManager.isOpen())
                entityManager.close();
        }
        return player;
    }

    public void insertPlayer(Player player) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.persist(player);
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

    public void deletePlayer(int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaDelete<Player> delete = cb.
                    createCriteriaDelete(Player.class);
            Root e = delete.from(Player.class);
            delete.where(cb.equal(e.get("idPlayers"), id));
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

    public void updatePlayer(Player player, int id) throws DAOException {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();

            CriteriaUpdate<Player> update = cb.
                    createCriteriaUpdate(Player.class);

            Root e = update.from(Player.class);
            update.set("name", player.getName());
            update.set("transfer_cost", player.getTransfer_cost());
            update.set("goals", player.getGoals());
            update.set("club_id", player.getClub_id());
            update.where(cb.equal(e.get("idPlayers"), id));

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
