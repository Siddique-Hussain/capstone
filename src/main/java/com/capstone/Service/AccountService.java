package com.capstone.Service;

import com.capstone.Model.Account;
import com.capstone.Model.Customer;
import com.capstone.Repository.AccountRepo;
import com.capstone.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepo accrepo;
    @Autowired
    CustomerRepo cstrepo;

    public Customer createAccount(Account acc, Integer cstId)
    {
        Customer cst= cstrepo.getById(cstId);
        //cst.addAc(acc);
//        ArrayList<Account> list= new ArrayList<>();
//        list.add(acc);
//        cst.setAc(list);
        List<Account> list = cst.getAc();
        list.add(acc);
        cst.setAc(list);
        return cstrepo.save(cst);

    }


    public void deleteAccount(Integer accId)
    {
        accrepo.deleteById(accId);
    }

    public List<Account> displayAccount()
    {
        return accrepo.findAll();
    }

    public Optional<Account> findAccount(Integer accId1)
    { return accrepo.findById(accId1);
    }

    public Integer tranferFund(Integer accId1, Integer accId2, Float amount) throws Exception
    {
        Account acc1= accrepo.getById(accId1);
        Account acc2= accrepo.getById(accId2);
        if(acc1.getFunds() < amount)
        {
            throw new Exception();
        }
        acc1.setFunds(acc1.getFunds()-amount);
        accrepo.save(acc1);
        acc2.setFunds(acc2.getFunds()+amount);
        accrepo.save(acc2);
        return accrepo.findCustomerwithACCId(accId1);


    }
}
