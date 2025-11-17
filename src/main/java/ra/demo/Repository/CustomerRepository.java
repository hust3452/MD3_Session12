package ra.demo.Repository;

import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.Login.Customer;

public interface CustomerRepository {

    Customer registerCustomer(Customer customer);

    Customer findById(long id);

    Customer findCustomerByEmail(String email);

    Customer login(String email, String password);
}
