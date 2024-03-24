package com.capstone.Controller;

import com.capstone.Model.Customer;
import com.capstone.Service.CustomerService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping("/customer/{CST_Id}")
    public Optional<Customer> Find( @PathVariable Integer CST_Id) throws Exception
    {
        if(service.findCustomer(CST_Id).isEmpty())
        {
            System.out.println("IN CONTROLLER");
            throw new Exception();

        }
        return service.findCustomer(CST_Id);
    }
    @DeleteMapping("/customer/{CST_Id}")
    public void Delete(@PathVariable Integer CST_Id)
    {
        System.out.println("Delet is tracking");
        service.deleteCustomer(CST_Id);
    }
    @GetMapping("/customer/all")
    public ArrayList<Customer> Display() throws Exception
    {
        if(service.displayCustomer().isEmpty())
        {
            throw new Exception();
        }
        return service.displayCustomer();

    }



    @GetMapping("/customer")
    public String Checking()
    {
        //return service.createCustomer(cst);
        return "working";
    }
    @GetMapping("/customer/byname/{name}")
    public Optional<Customer> findCustomerByName(@PathVariable String name) throws Exception
    {
        if(service.findCustomerByName(name).isEmpty())
        {
            throw new Exception();

        }
        return service.findCustomerByName(name);

    }
}
