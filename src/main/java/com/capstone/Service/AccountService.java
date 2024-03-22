package com.capstone.Service;

import com.capstone.Repository.AccountRepo;
import com.capstone.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountRepo accrepo;
    @Autowired
    CustomerRepo cstrepo;
}
