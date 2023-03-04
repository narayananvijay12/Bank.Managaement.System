package com.example.Bank.Managaement.System.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

        String name;
        String account_number;

    public UserNotFoundException(String name, String account_number) {
        super(String.format("User %s account number ending with xxxxxx%s is not found in our Database",name,account_number.subSequence(6,10)));
        this.name = name;
        this.account_number = account_number;
    }
    public UserNotFoundException(String account_number) {
        super(String.format("User account number ending with xxxxxx%s is not found in our Database",account_number));
        this.name = name;
        this.account_number = account_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }
}
