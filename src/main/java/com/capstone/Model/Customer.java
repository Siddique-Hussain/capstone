package com.capstone.Model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name="CustomerData")

public class Customer implements Serializable {
 @Id
 private Integer Id;
private String Name;
private String City;
@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL)
        @JoinColumn(name="Cust_Id", referencedColumnName = "Id")//account,customer
List<Account> ac= new ArrayList<Account>();

    public void addAc(Account acc) {
         ac.add(acc);
    }
}