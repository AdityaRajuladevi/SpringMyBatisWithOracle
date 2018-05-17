package com.mybatis.example.demomybatis.controller;

import com.mybatis.example.demomybatis.service.dao.CustomerDAO;
import com.mybatis.example.demomybatis.service.dao.FullCustomerDAO;
import com.mybatis.example.demomybatis.service.dao.LocationDAO;
import com.mybatis.example.demomybatis.service.model.*;
import oracle.jdbc.proxy.annotation.Post;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
@MapperScan("com.mybatis.example.demomybatis.service.mapper")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private LocationDAO locationDAO;


    @Autowired
    private FullCustomerDAO fullCustomerDAO;

    // Retrieves list of department
    @GetMapping("/getCustomers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(customerDAO.getAllCustomers());
    }

    // Retrieves list of locations
    @GetMapping("/getLocations")
    public ResponseEntity<List<Location>> getLocations(){
        return ResponseEntity.ok(locationDAO.getAllLocations());
    }

    // Retrieves list of Customers Full details
    @GetMapping("/getCustomersInfo")
    public ResponseEntity<List<FullCustomer>> getCustomerFullDetails(){
        return ResponseEntity.ok(fullCustomerDAO.getAllCustomerDetails());
    }

    @GetMapping("/insert")
    public ResponseEntity<List<Customer>> insertCustomerAndFetch(){
        Customer c= new Customer();
        //c.setCUSTOMER_ID();
        int l=new Random().nextInt();
        c.setCustomer_name("TestUser "+l);
        c.setLocation_id(1100);
        return ResponseEntity.ok(customerDAO.addCustomer(c));
    }

//    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//    public ResponseEntity<?> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
//        //logger.info("Creating User : {}", user);
//
//        if (userService.isUserExist(user)) {
//            logger.error("Unable to create. A User with name {} already exist", user.getName());
//            return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " +
//                    user.getName() + " already exist."), HttpStatus.CONFLICT);
//        }
//        userService.saveUser(user);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
//        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
//    }

    @PostMapping("/update")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        System.out.println(" Received customer "+ customer.getCustomer_name() + customer.getLocation_id());

//        if (customer != null)
//            return ResponseEntity.ok(customerDAO.addandReturnCustomer(customer));
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @RequestMapping(value = "/persistCustomer", method = RequestMethod.POST)
    public ResponseEntity<Customer> persistCustomer(@RequestBody Customer customer) {
        if (customer!=null) {
            //return ResponseEntity.ok(customerDAO.addandReturnCustomer(customer));
            Customer c=customerDAO.addandReturnCustomer(customer);
            return new ResponseEntity<Customer>(c, HttpStatus.CREATED);
            //return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }



    @PostMapping("/save")
    public ResponseEntity<FullCustomer> saveCustomer(@RequestBody FullCustomer fullCustomer)
    {
        // perform data validation and then save it into the backend
        if (fullCustomer!=null) {
            FullCustomer c=fullCustomerDAO.insertFullCustomer(fullCustomer);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }


    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity<String> persistPerson(@RequestBody Person person) {
        if (person!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

}
