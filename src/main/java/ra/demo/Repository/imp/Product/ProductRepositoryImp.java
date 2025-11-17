package ra.demo.Repository.imp.Product;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.demo.Model.Product.Product;
import ra.demo.Repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("FROM Product",Product.class).getResultList();
    }

    @Override
    public Product findById(long id) {
        return entityManager.createQuery("FROM Product WHERE id = :id",Product.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public boolean save(Product product) {
        try{
            entityManager.persist(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(long id){
        try{
            Product product = findById(id);
            entityManager.remove(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean updateById(Product product){
        try{
            entityManager.merge(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
