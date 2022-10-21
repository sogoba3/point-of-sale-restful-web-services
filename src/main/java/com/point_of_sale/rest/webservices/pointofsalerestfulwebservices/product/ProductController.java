package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.product;

import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productCategory.ProductCategoryRepository;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productUnit.ProductUnit;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productUnit.ProductUnitRepository;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.receiveProduct.ReceiveProduct;
import com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.receiveProduct.ReceiveProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Autowired
    private ProductUnitRepository productUnitRepository;

    @Autowired
    private ReceiveProductRepository receiveRepository;
//
//    @Autowired
//    private User user;

                            // Products features/functionalities

    @GetMapping("/products")
    public List<Product> retrieveAllProducts(){

        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}")
    public Optional<Product> retrieveProduct(@PathVariable int productId) throws Exception {
         Optional<Product> product = productRepository.findById(productId);


        //"All-Products", SERVER_PATH + "/products"
        //RetrievedAllProducts

         return product;
    }
    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody Product product) throws Exception{
        Product createdProduct = productRepository.save(product);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/product}")
                .buildAndExpand(createdProduct.getProductId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable int productId) throws Exception{
        productRepository.deleteById(productId);

    }

    //Updtating a  products
    @PutMapping("/products/{productId}")
    @Transactional
    public ResponseEntity<Product> productUpdate(@RequestBody Product productDetails, @PathVariable int productId) {

        Product product = productRepository.getById(productId);

        //Product body
        product.setCode(productDetails.getCode());
        product.setName(productDetails.getName());
        product.setUnitPrice(productDetails.getUnitPrice());
        product.setUnitInStock(productDetails.getUnitInStock());
        product.setDiscountPercentage(productDetails.getDiscountPercentage());

        final Product updateProduct = productRepository.save(product);
        return ResponseEntity.ok(updateProduct);
    }

    //Features for product units

                        // ProductUnits features/functionalities in connection with Products --> @ManyToOne relationship
    //get different products units
    @GetMapping("/products/{productId}/units")
    public List<ProductUnit> retrieveUnitsForProduct(@PathVariable int productId) throws Exception{
        Optional<Product> productOptional = productRepository.findById(productId);
//        Optional<ProductUnit> productUnit = productUnitRepository.findById(unitId);

       return productOptional.get().getProductUnit();
//        return productUnit.get().getProduct();
    }



    @PostMapping("/products/{productId}/units")
    public ProductUnit createUnitForProducts(@PathVariable int productId, @RequestBody ProductUnit productUnit) throws Exception{
        Optional<Product> productOptional = productRepository.findById(productId);

        Product product = productOptional.get();

        productUnit.setProduct(product);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{/product}")
//                .buildAndExpand(product.getProductId())
//                .toUri();
          return productUnitRepository.save(productUnit);

//        return ResponseEntity.created(location).build();
    }






    @GetMapping("/products/{productId}/receiveProducts")
    public List<ReceiveProduct> retrieveReceiveForProduct(@PathVariable int productId) throws Exception{
        Optional<Product> productOptional = productRepository.findById(productId);
//        Optional<ProductUnit> productUnit = productUnitRepository.findById(unitId);

        return productOptional.get().getReceiveProduct();
//        return productUnit.get().getProduct();
    }

    @PostMapping("/products/{productId}/receiveProducts")
    public ReceiveProduct createReceiveProdForProducts(@PathVariable int productId, @RequestBody ReceiveProduct receiveProduct) throws Exception{
        Optional<Product> productOptional = productRepository.findById(productId);

        Product product = productOptional.get();

        receiveProduct.setProduct(product);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{/product}")
//                .buildAndExpand(product.getProductId())
//                .toUri();
        return receiveRepository.save(receiveProduct);

//        return ResponseEntity.created(location).build();
    }

}
