package com.example.Bank.Managaement.System.service.impl;

import com.example.Bank.Managaement.System.Exception.InsufficientBalanceException;
import com.example.Bank.Managaement.System.Exception.UserNotFoundException;
import com.example.Bank.Managaement.System.model.AmountDepoist;
import com.example.Bank.Managaement.System.model.AmountWithdrwal;
import com.example.Bank.Managaement.System.model.AxisBank;
import com.example.Bank.Managaement.System.model.CurrencyRates;
import com.example.Bank.Managaement.System.repository.BankRepository;
import com.example.Bank.Managaement.System.service.BankService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    BankRepository bankRepository;

    @Override
    public AxisBank accountCreation(AxisBank axisBank) {

       /* AxisBank axisBankAmountDepoist = bankRepository.findOne(axisBank.getAadhar_number()).
                orElseThrow(() -> new UserNotFoundException
                        (amountWithdrwal.getAccount_number().toString()));*/
        return bankRepository.save(axisBank);
    }

    @Override
    public AxisBank profileUpdation(AxisBank axisBank) {
        AxisBank axisBankUpdateDeatils = bankRepository.findById(axisBank.getAccount_number()).
                orElseThrow(() -> new UserNotFoundException(axisBank.getName(),
                        axisBank.getAccount_number().toString()));
        axisBankUpdateDeatils.setPhone_number(axisBank.getPhone_number());
        axisBankUpdateDeatils.setAddress(axisBank.getAddress());
        return bankRepository.save(axisBankUpdateDeatils);
    }

    @Override
    public AxisBank amountDepoist(AmountDepoist amountDepoist) {
        AxisBank axisBankAmountDepoist = bankRepository.findById(amountDepoist.getAccount_number()).
                orElseThrow(() -> new UserNotFoundException
                        (amountDepoist.getAccount_number().toString()));
        Double userCurrentBalance = axisBankAmountDepoist.getAccount_balance();
        userCurrentBalance+= amountDepoist.getDepoist_amount();
        axisBankAmountDepoist.setAccount_balance(userCurrentBalance);
        return bankRepository.save(axisBankAmountDepoist);
    }

    @Override
    public <T> Object amountWithdrwal(AmountWithdrwal amountWithdrwal) {
        int mininum_balance = 2000;
        AxisBank axisBankAmountDepoist = bankRepository.findById(amountWithdrwal.getAccount_number()).
                orElseThrow(() -> new UserNotFoundException
                        (amountWithdrwal.getAccount_number().toString()));
        Double userCurrentBalance = axisBankAmountDepoist.getAccount_balance();
           if( mininum_balance < userCurrentBalance-(amountWithdrwal.getWithdrwal_amount())) {
               axisBankAmountDepoist.setAccount_balance(userCurrentBalance - (amountWithdrwal.getWithdrwal_amount()));
               return  bankRepository.save(axisBankAmountDepoist);
        }else{
            throw new InsufficientBalanceException
                    (amountWithdrwal.getAccount_number().toString());
        }
    }

    @Override
    public CurrencyRates getCurrencyRate() {
        String url_str = "https://api.exchangerate.host/latest";
        RestTemplate restTemplate= new RestTemplate();
        CurrencyRates currency =restTemplate.getForObject(url_str,CurrencyRates.class);
        return currency;
    }
}
