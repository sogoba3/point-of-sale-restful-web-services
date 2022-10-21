package com.point_of_sale.rest.webservices.pointofsalerestfulwebservices.user;

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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;


//    @GetMapping("/users")
//    public List<User> retrieveUsers(){
//
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{userId}")
//    public Optional<User> retrieveUser(@PathVariable int userId) throws Exception {
//        Optional<User> user = userRepository.findById(userId);
//
//
//        //"All-users", SERVER_PATH + "/users"
//        //RetrievedAllUsers
//
//        return user;
//    }
//    @PostMapping("/users")
//    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) throws Exception{
//        User createdUser = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("{/user}")
//                .buildAndExpand(createdUser.getUserId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
//
//    @DeleteMapping("/users/{userId}")
//    public void deleteUser(@PathVariable int userId) throws Exception{
//        userRepository.deleteById(userId);
//
//    }
//
//    //Updtating   users
//    @PutMapping("/users/{userId}")
//    public ResponseEntity<User> userUpdate(@RequestBody User userDetails, @PathVariable int userId) {
//
//        User user = userRepository.getById(userId);
//
//        //User body
//        user.setFirstName(userDetails.getFirstName());
//        user.setLastName(userDetails.getLastName());
//        user.setContact(userDetails.getContact());
//        user.setDesignation(userDetails.getDesignation());
//        user.setAccountType(userDetails.getAccountType());
//
//        user.setUserName(userDetails.getUserName());
//        user.setPassword(userDetails.getPassword());
//
//        final User updateUser = userRepository.save(user);
//        return ResponseEntity.ok(updateUser);
//    }
//
//
//
//    @GetMapping("/users/{userId}/products")
//    public List<Product> retrieveUsersProducts(@PathVariable int userId) throws Exception{
//        Optional<User> userOptional = userRepository.findById(userId);
////        Optional<ProductUnit> productUnit = productUnitRepository.findById(unitId);
//
//        return userOptional.get().getProduct();
////        return productUnit.get().getProduct();
//    }
//
//
//
//    @PostMapping("/users/{userId}/products")
//    public Product createUserProducts(@PathVariable int userId, @RequestBody Product product) throws Exception{
//        Optional<User> userOptional = userRepository.findById(userId);
//
//        User user = userOptional.get();
//
//        product.setUser(user);
////        URI location = ServletUriComponentsBuilder
////                .fromCurrentRequest()
////                .path("{/product}")
////                .buildAndExpand(product.getProductId())
////                .toUri();
//        return productRepository.save(product);
//
////        return ResponseEntity.created(location).build();
//    }

}
