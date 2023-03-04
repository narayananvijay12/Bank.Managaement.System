package com.example.Bank.Managaement.System.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String account_number) {
        super(String.format("Requested amount is violates minimum balance constraint for account number xxxx%s", account_number.subSequence(6,10)));
    }
}
