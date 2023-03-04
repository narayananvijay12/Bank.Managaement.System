package com.example.Bank.Managaement.System;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

public class MyGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        //return UUID.randomUUID().toString().replace("-", "");
        // or any other logic you'd like
        // for generating unique IDs
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = (int) rnd.nextLong();

        // this will convert any number sequence into 6 character.
        return Long.valueOf("%10d", number);
    }
}