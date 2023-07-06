package com.example.Bank.Managaement.System.controller;

import com.example.Bank.Managaement.System.model.AmountDepoist;
import com.example.Bank.Managaement.System.model.AmountWithdrwal;
import com.example.Bank.Managaement.System.model.AxisBank;
import com.example.Bank.Managaement.System.model.CurrencyRates;
import com.example.Bank.Managaement.System.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {
    @Autowired
    BankService bankService;
    int i=1;


    @PostMapping("/account_creation")
    public ResponseEntity<AxisBank> accountCreation(@RequestBody AxisBank axisBank){
        if(i==1){
            System.out.println("Inside the account creation");
        }
        return new ResponseEntity<AxisBank>(bankService.accountCreation(axisBank), HttpStatus.CREATED);

    }
//
    @PutMapping("/profile_update")
    public ResponseEntity<AxisBank> profileUpdate(@RequestBody AxisBank axisBank){
         
        return new ResponseEntity<AxisBank>(bankService.profileUpdation(axisBank), HttpStatus.OK);

    }

    @PutMapping("/amount_depoist")
    public ResponseEntity<AxisBank> amountDepoist(@RequestBody AmountDepoist amountDepoist){
        return new ResponseEntity<AxisBank>(bankService.amountDepoist(amountDepoist), HttpStatus.ACCEPTED);
    }

    @PutMapping("/amount_withdrwal")
    public ResponseEntity<Object> amountWithdrwal(@RequestBody AmountWithdrwal amountWithdrwal){
        return new ResponseEntity<Object>(bankService.amountWithdrwal(amountWithdrwal), HttpStatus.ACCEPTED);
    }

    @GetMapping("/currency_rate")
    public CurrencyRates getCurrencyRate(){
        return  bankService.getCurrencyRate();
    }
}
