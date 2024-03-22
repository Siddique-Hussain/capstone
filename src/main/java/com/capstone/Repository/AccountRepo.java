package com.capstone.Repository;

import com.capstone.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer>
{
    @Query(value="SELECT CUST_ID FROM ACCOUNT_DATA where ID = ?1", nativeQuery = true)
    Integer findCustomerwithACCId(Integer Id);
}
