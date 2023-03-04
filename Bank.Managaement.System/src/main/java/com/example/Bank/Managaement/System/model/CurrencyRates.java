package com.example.Bank.Managaement.System.model;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class CurrencyRates {
    private Motd motd;
    private boolean success;
    private String base;
    private Date date;
    private Map<String,Double> rates;
}
