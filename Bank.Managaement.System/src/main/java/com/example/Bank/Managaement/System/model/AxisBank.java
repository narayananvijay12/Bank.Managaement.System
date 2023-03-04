package com.example.Bank.Managaement.System.model;

import com.example.Bank.Managaement.System.MyGenerator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.*;

@Data
@Entity
@Table(name="Axis_Bank")
public class AxisBank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long account_number;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
     String aadhar_number;

    @Column(nullable = false)
     String gender;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.ANY, pattern = "dd-MM-yyyy")
     Date date_of_birth;

    @Column(nullable = false)
     String address;

    @Column(nullable = false)
     String account_type;

    @Column(nullable = false)
     Double account_balance;

    @Column(nullable = false)
     BigInteger phone_number;

    @Column(nullable = false)
     String email_id;
}
