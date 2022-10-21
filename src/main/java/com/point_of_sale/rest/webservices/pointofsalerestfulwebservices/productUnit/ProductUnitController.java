package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.productUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductUnitController {

    @Autowired
    private ProductUnitRepository productUnitRepository;


    @GetMapping("/units")
    public List<ProductUnit> retrieveProductUnits(){

        return productUnitRepository.findAll();
    }

    @GetMapping("/units/{unitId}")
    public Optional<ProductUnit> retrieveProductUnit(@PathVariable int unitId) throws Exception {
        Optional<ProductUnit> product = productUnitRepository.findById(unitId);


        //"All-Products", SERVER_PATH + "/products"
        //RetrievedAllProducts

        return product;
    }
    @PostMapping("/units")
    public ResponseEntity<Object> createUnits(@Valid @RequestBody ProductUnit productUnit) throws Exception{
        ProductUnit createdProduct = productUnitRepository.save(productUnit);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/unit}")
                .buildAndExpand(createdProduct.getUnitId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/units/{unitId}")
    public void deleteProductUnit(@PathVariable int unitId) throws Exception{
        productUnitRepository.deleteById(unitId);

    }

    @PutMapping("/units/{unitId}")
    public ResponseEntity<ProductUnit> productUnitUpdate(@RequestBody ProductUnit productUnitDetails, @PathVariable int unitId) {

        ProductUnit productUnit = productUnitRepository.getById(unitId);

        //Product body
        productUnit.setName(productUnitDetails.getName());

        final ProductUnit updateProductUnit = productUnitRepository.save(productUnit);
        return ResponseEntity.ok(updateProductUnit);
    }

}
