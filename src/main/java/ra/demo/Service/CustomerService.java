package ra.demo.Service;

import ra.demo.DTO.Login.CustomerDTO;
import ra.demo.DTO.Login.CustomerLoginDTO;
import ra.demo.Model.Login.Customer;

public interface CustomerService {
    public Customer findAll();

    public Customer registerCustomer(CustomerDTO customerDTO);

    public Customer findCustomerByEmail(String email);

    public Customer login(CustomerLoginDTO customerLoginDTO);
}
