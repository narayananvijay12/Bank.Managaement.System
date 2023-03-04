package com.example.Bank.Managaement.System.service;

import com.example.Bank.Managaement.System.model.AmountDepoist;
import com.example.Bank.Managaement.System.model.AmountWithdrwal;
import com.example.Bank.Managaement.System.model.AxisBank;
import com.example.Bank.Managaement.System.model.CurrencyRates;

public interface BankService {
    AxisBank accountCreation(AxisBank axisBank);
    AxisBank profileUpdation(AxisBank axisBank);
    AxisBank amountDepoist(AmountDepoist amountDepoist);
    <T> Object amountWithdrwal(AmountWithdrwal withdrwalAmount);
    CurrencyRates getCurrencyRate();
}
