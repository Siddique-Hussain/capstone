package com.capstone.Controller;

import com.capstone.Model.Customer;
import com.capstone.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CustomerController
{
    @Autowired
    CustomerService service;
    //create customer with account
    @PostMapping("/customer")
    public Customer Create(@RequestBody Customer cst)
    {
        System.out.println("In Controller");
        return service.createCustomer(cst);
        //return cst;
    }
//    public Optional<Customer> Find(Integer cst)
//    {
//        if(service)
//    }
    @GetMapping("/customer")
    public String Checking()
    {
        //return service.createCustomer(cst);
        return "working";
    }
}
