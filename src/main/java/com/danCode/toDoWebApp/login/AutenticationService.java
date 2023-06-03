package com.danCode.toDoWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AutenticationService {
    public boolean authentication(String username,String password){
        boolean isValidUser = username.equalsIgnoreCase("dani");
        boolean isValidPw = password.equalsIgnoreCase("dani");

        return isValidUser && isValidPw;
    }
}
