package ra.demo.Service.imp.Login;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo.DTO.Login.CustomerDTO;
import ra.demo.DTO.Login.CustomerLoginDTO;
import ra.demo.Model.Login.Customer;
import ra.demo.Model.Login.Role;
import ra.demo.Repository.CustomerRepository;
import ra.demo.Service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findAll() {
        return null;
    }

    @Override
    public Customer registerCustomer(CustomerDTO customerDTO) {
        Customer customer = convertCustomerDTOToCustomer(customerDTO);
        customer.setRole(Role.CUSTOMER);
        return customerRepository.registerCustomer(customer);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

    @Override
    public Customer login(CustomerLoginDTO customerLogin) {
        return customerRepository.login(customerLogin.getEmail(),customerLogin.getPassword());
    }

    public Customer convertCustomerDTOToCustomer(CustomerDTO customerDTO) {
        return Customer
                .builder()
                .customerName(customerDTO.getCustomerName())
                .phone(customerDTO.getPhone())
                .password(customerDTO.getPassword())
                .email(customerDTO.getEmail())
                .build();
    }
}
