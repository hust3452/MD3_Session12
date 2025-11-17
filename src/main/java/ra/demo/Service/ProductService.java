package ra.demo.Service;

import org.springframework.transaction.annotation.Transactional;
import ra.demo.DTO.Product.ProductDTO;
import ra.demo.Model.Product.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    boolean addProduct(ProductDTO productDTO);

    Product findProductById(long id);

    boolean deleteProductById(long id);

    boolean updateById(ProductDTO productDTO, long id);

    Product convertProductDTOToProduct(ProductDTO productDTO);

    ProductDTO convertProductToProductDTO(Product product);
}
