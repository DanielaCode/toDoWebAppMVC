package com.danCode.toDoWebApp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("name")
public class LoginController {

    private AutenticationService auth;
    private Logger logger = LoggerFactory.getLogger(getClass());

    public LoginController(AutenticationService auth) {
        this.auth = auth;
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String goToLogin(){
        return "login";
    }
    //we can cash queryParma and form data same way
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String goToWelcome(@RequestParam String name, String password, ModelMap model){
        if (auth.authentication(name,password)){
            model.put("name",name);
            return "welcome";

        }else{
            model.put("error","User name or password is not correct");
            return "login";
        }


     }

}
