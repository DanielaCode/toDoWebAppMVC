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
    //@RequestMapping("login") this is using to manage GET, POST Request we can see it on inspector that firs response is get when I put de url /login and second is when I entered the user and password and submit the form has post and both return the login view because this method is managing both, so to avoid it we can use:
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    //so if a try to do a form submit it will be an error

}
