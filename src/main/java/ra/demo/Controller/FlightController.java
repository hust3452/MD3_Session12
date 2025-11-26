package ra.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.demo.DTO.FlightDTO;
import ra.demo.Model.Flight;
import ra.demo.Service.FlightService;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public String flight(@RequestParam(defaultValue = "1") int page,
                         @RequestParam(defaultValue = "10") int size,
                         @RequestParam(defaultValue = "") String searchName,
                         Model model) {
        List<Flight> flights = flightService.findAll(page, size, searchName);
        long totalElement = flightService.countTotalElement(searchName);
        int totalPages = (int) Math.ceil((double) totalElement / size);
        List<Integer> pages = new ArrayList<Integer>();
        for (int i = 1; i <= totalPages; i++) {
            pages.add(i);
        }
        model.addAttribute("page", page);
        model.addAttribute("pages", pages);
        model.addAttribute("flights", flights);
        model.addAttribute("searchName", searchName);
        model.addAttribute("totalElement", totalElement);
        model.addAttribute("size", size);
        return "FlightHome";
    }

    @GetMapping("/searchInfo")
    public String flightSearchInfo(@RequestParam(defaultValue = "1") int page,
                                   @RequestParam(defaultValue = "10") int size,
                                   @RequestParam(defaultValue = "") String startingPoint,
                                   @RequestParam(defaultValue = "") String destination,
                                   Model model) {
        if (startingPoint == null || startingPoint.isEmpty() || destination == null || destination.isEmpty()) {
            return "redirect:/flight";
        } else {
            List<Flight> flights = flightService.findInfo(page, size, startingPoint, destination);
            long totalElement = flightService.countTotalInfo(startingPoint, destination);
            int totalPages = (int) Math.ceil((double) totalElement / size);
            List<Integer> pages = new ArrayList<Integer>();
            for (int i = 1; i <= totalPages; i++) {
                pages.add(i);
            }
            model.addAttribute("page", page);
            model.addAttribute("pages", pages);
            model.addAttribute("flights", flights);
            model.addAttribute("startingPoint", startingPoint);
            model.addAttribute("destination", destination);
            model.addAttribute("totalElement", totalElement);
            model.addAttribute("size", size);
            return "FlightHome";
        }
    }

    @GetMapping("/initCreate")
    public String initCreate(Model model) {
        model.addAttribute("flightDTO", new FlightDTO());
        return "FlightAdd";
    }

    @PostMapping("/create")
    public String initCreate(@Valid @ModelAttribute("flightDTO") FlightDTO flightDTO,
                             BindingResult bindingResult, Model model) {
        if (flightDTO.getTravelImage() == null || flightDTO.getTravelImage().isEmpty()) {
            bindingResult.rejectValue("travelImage", "error.image.empty", "travelImage cannot be empty");
        }
        if (bindingResult.hasErrors()) {
            return "FlightAdd";
        }
        boolean result = flightService.addFlight(flightDTO);
        if (result) {
            return "redirect:/flight";
        }
        return "Error";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        try {
            boolean result = flightService.deleteFlight(id);
            if (result) {
                return "redirect:/flight";
            } else {
                return "Error";
            }
        } catch (Exception e) {
            return "Error";
        }
    }

    @GetMapping("/edit/{id}")
    public String editFlight(@PathVariable int id, Model model) {
        Flight flight = flightService.findById(id);
        model.addAttribute("editFlightDTO", flight);
        return "FlightEdit";
    }

    @PostMapping("/edit/{id}")
    public String editFlight(@PathVariable int id, @Valid @ModelAttribute("editFlightDTO") FlightDTO flightDTO, BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "FlightEdit";
        }
        boolean newFlight = flightService.editById(flightDTO, id);
        if (newFlight) {
            return "redirect:/flight";
        } else {
            model.addAttribute("editFlightDTO", flightDTO);
            return "Error";
        }
    }
}
