package ra.demo.Controller.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ra.demo.DTO.Product.ProductDTO;
import ra.demo.Model.Product.Product;
import ra.demo.Service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/productController")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public String findAllProduct(Model model){
        model.addAttribute("listProduct",productService.findAll());
        return "Product/ProductHome";
    }

    @GetMapping("/initCreate")
    public String initCreateProduct(Model model){
        model.addAttribute("productDTO",new ProductDTO());
        return "Product/AddNewProduct";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("productDTO") ProductDTO productDTO, BindingResult bindingResult,
                                Model model){
        if(bindingResult.hasErrors()){
            return "Product/AddNewProduct";
        }
        boolean result = productService.addProduct(productDTO);
        if (result){
            return "redirect:/productController";
        }else {
        model.addAttribute("message","Book added Failed");
        model.addAttribute("productDTO",productDTO);
        return "Product/Error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model){
        try{
        boolean result = productService.deleteProductById(id);

        if(result){
            return "redirect:/productController";
        }else{
            return "Product/Error";
        }
    }catch (Exception e){
            return "Product/Error";
        }
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable long id, Model model){
        Product product = productService.findProductById(id);
        model.addAttribute("updateProductDTO",product);
        return "Product/UpdateProduct";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable long id,@Valid @ModelAttribute("updateProductDTO") ProductDTO productDTO, BindingResult bindingResult,
                                Model model){

        if (bindingResult.hasErrors()){
            return "Product/UpdateProduct";
        }
        boolean newProduct = productService.updateById(productDTO,id);
        if (newProduct){
            return "redirect:/productController";
        }else {
            model.addAttribute("message","Book update Failed");
            model.addAttribute("updateProductDTO",productDTO);
            return "Product/Error";
        }
        }
}
