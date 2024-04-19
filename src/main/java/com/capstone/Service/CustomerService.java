package com.capstone.Service;

import com.capstone.Exception.ResourseNotFound;
import com.capstone.Model.Customer;
import com.capstone.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo repo;
    public Customer createCustomer(Customer cst)
    {
        System.out.println("In Service");
        return repo.save(cst);
    }

    public Optional<Customer> findCustomer(Integer cstId) throws ResourseNotFound
    {
        if(repo.findById(cstId).isEmpty())
        {
            System.out.println("Reaching");
            throw new ResourseNotFound("String is Empty");

        }
        return repo.findById(cstId);
    }

    public void deleteCustomer(Integer cstId) throws ResourseNotFound
    {
        if(repo.findById(cstId).isEmpty())
        {
            //System.out.println("");
            throw new ResourseNotFound("No Item is there to Deleted");

        }

        System.out.println("Inside delete repo");
        repo.deleteById(cstId);
    }

    public ArrayList<Customer> displayCustomer()
    {
        return (ArrayList<Customer>) repo.findAll();
    }

    public Optional<Customer> findCustomerByName(String name)
    {
        return repo.findbyName(name);
    }
}
