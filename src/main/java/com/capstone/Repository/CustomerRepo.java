package com.capstone.Repository;

import com.capstone.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer>
{
    @Query("from Customer c where c.Name in ?1")
    Optional<Customer>  findbyName(String Name);
}
