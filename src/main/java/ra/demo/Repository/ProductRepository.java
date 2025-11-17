package ra.demo.Repository;

import org.springframework.transaction.annotation.Transactional;
import ra.demo.DTO.Product.ProductDTO;
import ra.demo.Model.Product.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(long id);

    boolean save(Product product);

    boolean delete(long id);

    boolean updateById(Product product);

//    boolean updateById(Product product);
}
