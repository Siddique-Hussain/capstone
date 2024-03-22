package com.capstone.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name= "AccountData")

public class Account implements Serializable
{
    @Id
    private Integer Id;
    private Float funds;
    private String type;




}
