package com.danCode.toDoWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }
    //we can cash queryParma and form data same way
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, String password, ModelMap model){
        model.put("name",name);
        return "welcome";
    }

}
