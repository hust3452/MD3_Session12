package ra.demo.Controller.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.demo.DTO.Login.CustomerDTO;
import ra.demo.Model.Login.Customer;
import ra.demo.Service.CustomerService;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String findAllCustomer(Model model) {
        model.addAttribute("ListCustomer", customerService.findAll());
        return "Login/CustomerHome";
    }

    @GetMapping("/register")
    public String registerCustomer(Model model) {
        model.addAttribute("CustomerRegister", new CustomerDTO());
        return "Login/CustomerRegister";
    }

    @PostMapping("/register")
    public String registerCustomer(@Valid @ModelAttribute("CustomerRegister") CustomerDTO customerDTO,
                                   BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "Login/CustomerRegister";
        }

//        Customer existing = customerService.findCustomerByEmail(customerDTO.getEmail());
//        if (existing != null) {
//            model.addAttribute("emailExist", "email already in use");
//            return "Login/CustomerRegister";
//        }

        Customer customer = customerService.registerCustomer(customerDTO);
        if (customer == null) {
            model.addAttribute("message", "Register failed");
            model.addAttribute("CustomerRegister", customerDTO);
            return "Login/CustomerError";
        } else {
                return "Login/Login";
            }
        }
}

