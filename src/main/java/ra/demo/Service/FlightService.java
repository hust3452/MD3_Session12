package ra.demo.Service;

import org.springframework.stereotype.Service;
import ra.demo.DTO.FlightDTO;
import ra.demo.Model.Flight;

import java.util.List;

public interface FlightService {

    boolean addFlight(FlightDTO flightDTO);

    boolean deleteFlight(int id);

    Flight findById(int id);

    boolean editById(FlightDTO flightDTO, int id);

    Flight convertFlightDTOToFlight(FlightDTO flightDTO);

    List<Flight> findAll(int page, int size, String searchName);

    long countTotalElement(String searchName);

    long countTotalInfo(String startingPoint, String destination);

    List<Flight> findInfo(int page, int size, String startingPoint, String destination);
}
