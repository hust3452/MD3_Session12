package ra.demo.Service.imp.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ra.demo.DTO.Product.ProductDTO;
import ra.demo.Model.Product.Product;
import ra.demo.Repository.ProductRepository;
import ra.demo.Service.ProductService;
import ra.demo.Service.UploadFileService;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UploadFileService uploadFileService;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean deleteProductById(long id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean addProduct(ProductDTO productDTO) {
        String imageURL = uploadFileService.uploadFile(productDTO.getImage());

        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setAuthor(productDTO.getAuthor());
        product.setPrice(productDTO.getPrice());
        product.setPublicYear(productDTO.getPublicYear());
        product.setImage(imageURL);

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public boolean updateById(ProductDTO productDTO,long id){
    Product oldProduct = productRepository.findById(id);
    Product newproduct = convertProductDTOToProduct(productDTO);
    newproduct.setId(oldProduct.getId());
    if (productDTO.getImage() != null && !productDTO.getImage().isEmpty()){
        String imageURL = uploadFileService.uploadFile(productDTO.getImage());
        newproduct.setImage(imageURL);
    }else {
        newproduct.setImage(oldProduct.getImage());
    }
    return productRepository.updateById(newproduct);
    }

    @Override
    public Product convertProductDTOToProduct(ProductDTO productDTO){
        return Product
                .builder()
                .title(productDTO.getTitle())
                .author(productDTO.getAuthor())
                .price(productDTO.getPrice())
                .publicYear(productDTO.getPublicYear())
                .build();
    }

    @Override
    public ProductDTO convertProductToProductDTO(Product product){
        return ProductDTO
                .builder()
                .title(product.getTitle())
                .author(product.getAuthor())
                .price(product.getPrice())
                .publicYear(product.getPublicYear())
                .build();
    }
}
