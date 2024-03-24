package com.capstone.Controller;

import com.capstone.Model.Account;
import com.capstone.Model.Customer;
import com.capstone.Service.AccountService;
import com.capstone.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController
{
    @Autowired
    CustomerService cstservice;
    @Autowired
    AccountService service;

    //Create account for Existing
    @PostMapping("/account/{CST_Id}")
    public Customer create(@RequestBody Account acc, @PathVariable Integer CST_Id) throws Exception
    {
        if(cstservice.findCustomer(CST_Id).isEmpty())
        {
            throw new Exception();
        }
        return service.createAccount(acc,CST_Id);
    }
    @DeleteMapping("/account/{ACC_Id}")
    public void Delete(@PathVariable Integer ACC_Id)
    {
        service.deleteAccount(ACC_Id);

    }
    //Display All Account
    @GetMapping("/account")
    public List<Account> Display() throws Exception
    {
        if(service.displayAccount().isEmpty())
        {
            throw new Exception();
        }
        return service.displayAccount();
    }
    @PostMapping("/account/{ACC_Id1}/{ACC_Id2}/{Amount}")
    public Optional<Customer> TransferFund
            (@PathVariable Integer ACC_Id1,@PathVariable Integer ACC_Id2,@PathVariable Float Amount)throws Exception
    {
        if(service.findAccount(ACC_Id1).isEmpty() || service.findAccount(ACC_Id2).isEmpty())
        {
            throw new Exception();
        }
        return cstservice.findCustomer(service.tranferFund(ACC_Id1,ACC_Id2,Amount));

    }






}
