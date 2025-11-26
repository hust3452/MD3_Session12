package ra.demo.Repository.imp;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.Flight;
import ra.demo.Repository.FlightRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class FlightRepositoryImp implements FlightRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Flight findById(int id) {
        return entityManager.createQuery("FROM Flight WHERE id = :id", Flight.class)
                .setParameter("id", id).getSingleResult();

    }

    @Override
    @Transactional
    public boolean save(Flight flight) {
        try {
            entityManager.persist(flight);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        try {
            Flight flight = findById(id);
            entityManager.remove(flight);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateById(Flight newFlight) {
        try {
            entityManager.merge(newFlight);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public List<Flight> getAllFlight(int offset, int size, String searchName) {
        String jpql = "SELECT f FROM Flight f WHERE (:searchName IS NULL OR f.flightName LIKE :searchName)";
        TypedQuery<Flight> query = entityManager.createQuery(jpql, Flight.class);

        if (searchName == null || searchName.trim().isEmpty()) {
            query.setParameter("searchName", null);
        } else {
            query.setParameter("searchName", "%" + searchName + "%");
        }
        query.setFirstResult(offset);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public List<Flight> getInfo(int offset, int size, String startingPoint, String destination) {
        String jpql = "SELECT f FROM Flight f WHERE ((:startingPoint IS NULL) OR (:destination IS NULL) OR ((f.startingPoint LIKE :startingPoint) AND (f.destination LIKE :destination)))";
        TypedQuery<Flight> query = entityManager.createQuery(jpql, Flight.class);

        if (startingPoint == null || startingPoint.trim().isEmpty()) {
            query.setParameter("startingPoint", null);
        } else if (destination == null || destination.trim().isEmpty()) {
            query.setParameter("destination", null);
        } else {
            query.setParameter("startingPoint", "%" + startingPoint + "%");
            query.setParameter("destination", "%" + destination + "%");
        }
        query.setFirstResult(offset);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public long countTotalElement(String searchName) {
        try {
            String jpql = "SELECT COUNT(f) FROM Flight f WHERE(:searchName IS NULL OR f.flightName LIKE :searchName)";
            TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

            if (searchName == null || searchName.trim().isEmpty()) {
                query.setParameter("searchName", null);
            } else {
                query.setParameter("searchName", "%" + searchName + "%");
            }
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public long countTotalInfo(String startingPoint, String destination) {
        try {
            String jpql = "SELECT COUNT(f) FROM Flight f WHERE ((:startingPoint IS NULL) OR (:destination IS NULL) OR ((f.startingPoint LIKE :startingPoint) AND (f.destination LIKE :destination)))";
            TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);

            if (startingPoint == null || startingPoint.trim().isEmpty()) {
                query.setParameter("startingPoint", null);
            } else if (destination == null || destination.trim().isEmpty()) {
                query.setParameter("destination", null);
            }
            else {
                query.setParameter("startingPoint", "%" + startingPoint + "%");
                query.setParameter("destination", "%" + destination + "%");
            }
            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
