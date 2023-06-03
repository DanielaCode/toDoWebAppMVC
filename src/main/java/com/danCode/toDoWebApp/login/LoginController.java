package com.danCode.toDoWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //http://localhost:8081/login-jsp?name=dani
    @RequestMapping("login-jsp")
    public String login(@RequestParam String name){ //request param is binding what the client sends with this String name
        System.out.println(name);//not recommended for production
        return "login";
    }
}
