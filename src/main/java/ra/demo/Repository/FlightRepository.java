package ra.demo.Repository;

import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.Flight;

import java.util.List;

public interface FlightRepository {

    Flight findById(int id);

    boolean save(Flight flight);

    boolean delete(int id);

    boolean updateById(Flight newFlight);

    long countTotalElement(String searchName);

    List<Flight> getAllFlight(int offset, int size, String searchName);

    List<Flight> getInfo(int offset, int size, String startingPoint, String destination);

    long countTotalInfo(String startingPoint, String destination);
}
