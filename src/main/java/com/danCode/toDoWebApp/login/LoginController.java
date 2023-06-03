package com.danCode.toDoWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    //http://localhost:8081/login-jsp?name=dani
    @RequestMapping("login-jsp")
    public String login(@RequestParam String name, ModelMap model){ //request param is binding what the client sends with this String name
        //how can I use this variable to put it on my html? => with Model
        //whatever I want to use on jsp I put it into model
        model.put("name",name);
        return "login";
    }
}
