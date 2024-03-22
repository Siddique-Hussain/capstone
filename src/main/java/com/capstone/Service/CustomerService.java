package com.capstone.Service;

import com.capstone.Model.Customer;
import com.capstone.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo repo;
    public Customer createCustomer(Customer cst)
    {
        System.out.println("In Service");
        return repo.save(cst);
    }
}
