package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productCategory;

import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product.Product;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductCategoryController {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    // Products features/functionalities

    @GetMapping("/categories")
    public List<ProductCategory> retrieveAllProducts(){

        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{categoryId}")
    public Optional<ProductCategory> retrieveProductCategories(@PathVariable int categoryId) throws Exception {
        Optional<ProductCategory> productCategory = categoryRepository.findById(categoryId);


        //"All-Products", SERVER_PATH + "/products"
        //RetrievedAllProducts

        return productCategory;
    }
    @PostMapping("/categories")
    public ResponseEntity<Object> createProductCategory(@Valid @RequestBody ProductCategory productCategory) throws Exception{
        ProductCategory createdProductCategory = categoryRepository.save(productCategory);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/category}")
                .buildAndExpand(createdProductCategory.getCategoryId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteProductCategory(@PathVariable int categoryId) throws Exception{
        categoryRepository.deleteById(categoryId);

    }

    //Updtating  Categories
    @PutMapping("/categories/{categoryId}")
    public ResponseEntity<ProductCategory> productCategoryUpdate(@RequestBody ProductCategory productCategoryDetails,
                                                         @PathVariable int categoryId) {

        ProductCategory productCategory = categoryRepository.getById(categoryId);

        //ProductCategory body
        productCategory.setName(productCategoryDetails.getName());

        final ProductCategory updateProductCategory = categoryRepository.save(productCategory);
        return ResponseEntity.ok(updateProductCategory);
    }



    // ProductCategory features/functionalities in connection with product --> @OneToMany relationship

    @GetMapping("/productCategories/{categoryId}/products")
    public List<Product> retrieveCategoryProducts(@PathVariable int categoryId) throws Exception{
        Optional<ProductCategory> productCategoryOptional = categoryRepository.findById(categoryId);
//        Optional<ProductUnit> productUnit = productUnitRepository.findById(unitId);

        return productCategoryOptional.get().getProduct();
//        return productUnit.get().getProduct();
    }

    @PostMapping("/productCategories/{categoryId}/products")
    public Product createCategoryProducts(@PathVariable int categoryId, @RequestBody Product product) throws Exception {
//        Optional<Product> productOptional = productRepository.findById(productId);
        ProductCategory productCategory = categoryRepository.findById(categoryId).get();
//        Product product = productOptional.get();

        product.setProductCategory(productCategory);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/product}")
                .buildAndExpand(product.getProductId())
                .toUri();

        return productRepository.save(product);
    }
}
