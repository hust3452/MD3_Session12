package ra.demo.Repository.imp.Login;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.Login.Customer;
import ra.demo.Repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class CustomerRepositoryImp implements CustomerRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Customer registerCustomer(Customer customer) {
        entityManager.persist(customer);
        return customer;
    }

    @Override
    public Customer findById(long id){
        return entityManager.createQuery("FROM Customer c WHERE c.customerId=:customerId", Customer.class)
                            .setParameter("customerId", id).getSingleResult();
    }

    @Override
    public Customer findCustomerByEmail(String email){
        return entityManager.createQuery("FROM Customer c WHERE c.email=:email",Customer.class)
                .setParameter("email", email).getSingleResult();
    }

    @Override
    @Transactional
    public Customer login(String email, String password){
        try{
            return entityManager.createQuery("FROM Customer c WHERE c.email=:email AND c.password=:password",Customer.class)
                    .setParameter("email",email)
                    .setParameter("password",password)
                    .getSingleResult();

        }catch(Exception e){
            return null;
        }
    }

}
