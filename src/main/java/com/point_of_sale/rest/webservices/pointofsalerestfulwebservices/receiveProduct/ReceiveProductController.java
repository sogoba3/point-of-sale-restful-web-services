package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.receiveProduct;

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
public class ReceiveProductController {


    @Autowired
    private ReceiveProductRepository receiveRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/receiveProducts")
    public List<ReceiveProduct> retrieveReceiveProducts(){

        return receiveRepository.findAll();
    }

    @GetMapping("/receiveProducts/{receiveProductId}")
    public Optional<ReceiveProduct> retrieveReceiveProduct(@PathVariable int receiveProductId) throws Exception {
        Optional<ReceiveProduct> receiving = receiveRepository.findById(receiveProductId);


        //"All-Products", SERVER_PATH + "/products"
        //RetrievedAllProducts

        return receiving;
    }
    @PostMapping("/receiveProducts")
    public ResponseEntity<Object> createReceiveProducts(@Valid @RequestBody ReceiveProduct receiveProduct) throws Exception{
        ReceiveProduct createdReceivedProduct = receiveRepository.save(receiveProduct);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/receiveProducts}")
                .buildAndExpand(createdReceivedProduct.getReceiveProductId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/receiveProducts/{receiveProductId}")
    public void deleteReceivedProduct(@PathVariable int receiveProductId) throws Exception{
        receiveRepository.deleteById(receiveProductId);

    }

    //Updtating a  products
    @PutMapping("/receiveProducts/{receiveProductId}")
    public ResponseEntity<ReceiveProduct> receivedProductUpdate(@RequestBody ReceiveProduct receivedProductDetails, @PathVariable int receiveProductId) {

        ReceiveProduct receivedProduct = receiveRepository.getById(receiveProductId);

        //Product body
        receivedProduct.setQuantity(receivedProductDetails.getQuantity());
        receivedProduct.setUnitPrice(receivedProductDetails.getUnitPrice());
        receivedProduct.setSubTotal(receivedProductDetails.getSubTotal());
//        receivedProduct.setReceivedDate(receivedProductDetails.getReceivedDate());

        final ReceiveProduct updateReceivedProduct = receiveRepository.save(receivedProduct);
        return ResponseEntity.ok(updateReceivedProduct);
    }

}
