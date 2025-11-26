package ra.demo.Service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.DTO.FlightDTO;
import ra.demo.Model.Flight;
import ra.demo.Repository.FlightRepository;
import ra.demo.Service.FlightService;
import ra.demo.Service.UploadFileService;

import java.util.List;

@Service
public class FlightServiceImp implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UploadFileService uploadFileService;


    @Override
    public List<Flight> findAll(int page, int size, String searchName) {
        int offset = (page - 1) * size;
        return flightRepository.getAllFlight(offset,size,searchName);
    }

    @Override
    public long countTotalElement(String searchName) {
        return flightRepository.countTotalElement(searchName);
    }

    @Override
    public long countTotalInfo(String startingPoint, String destination){
      return flightRepository.countTotalInfo(startingPoint,destination);
    };


    @Override
    public List<Flight> findInfo(int page, int size, String startingPoint, String destination) {
        int offset = (page - 1) * size;
        return flightRepository.getInfo(offset,size,startingPoint,destination);
    }

    @Override
    public boolean addFlight(FlightDTO flightDTO) {

            String imageURL = uploadFileService.uploadFile(flightDTO.getTravelImage());

            Flight flight = new Flight();
            flight.setFlightName(flightDTO.getFlightName());
            flight.setDestination(flightDTO.getDestination());
            flight.setArrivalTime(flightDTO.getArrivalTime());
            flight.setStartingPoint(flightDTO.getStartingPoint());
            flight.setTimeUnit(flightDTO.getTimeUnit());
            flight.setDepartureDate(flightDTO.getDepartureDate());
            flight.setTravelImage(imageURL);
            flight.setStatus(flightDTO.getStatus());

            return flightRepository.save(flight);
    }

    @Override
    public boolean deleteFlight(int id){
        return flightRepository.delete(id);
    }

    @Override
    public Flight findById(int id){
        return flightRepository.findById(id);
    }

    @Override
    @Transactional
    public boolean editById(FlightDTO flightDTO, int id) {
        Flight oldFlight = flightRepository.findById(id);
        Flight newFlight = convertFlightDTOToFlight(flightDTO);
        newFlight.setId(oldFlight.getId());
        if (flightDTO.getTravelImage() != null && !flightDTO.getTravelImage().isEmpty()) {
            String imageURL = uploadFileService.uploadFile(flightDTO.getTravelImage());
            newFlight.setTravelImage(imageURL);
        }else{
            newFlight.setTravelImage(oldFlight.getTravelImage());
        }
        return flightRepository.updateById(newFlight);
    }

    @Override
    public Flight convertFlightDTOToFlight(FlightDTO flightDTO){
        return Flight
                .builder()
                .flightName(flightDTO.getFlightName())
                .destination(flightDTO.getDestination())
                .arrivalTime(flightDTO.getArrivalTime())
                .startingPoint(flightDTO.getStartingPoint())
                .timeUnit(flightDTO.getTimeUnit())
                .departureDate(flightDTO.getDepartureDate())
                .status(flightDTO.getStatus())
                .build();

    }



}
