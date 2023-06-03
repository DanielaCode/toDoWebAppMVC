package com.danCode.toDoWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
    //url:"say-hello  => "Hello"
    @RequestMapping("say-hello")
    @ResponseBody
    public  String sayHello(){
        return "Hello";
    }

    //this is just and example because this is not scalable, so we are going to use Views tho do this one
    @RequestMapping("say-hello-html")
    @ResponseBody
    public  String sayHelloHtml(){
        //return strings is not considered efficient so go for stringBuilder or string buffer
        //JSP java software pages view technology popular
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My html response</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("my first response with html");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    //url:"say-hello-jsp  => sayHello.jsp

    //@ResponseBody because this return directly what is the function returned
    //and I don't want it, I want to return my jsp, so I set in application.properties suffix and prefix
    @RequestMapping("say-hello-jsp")
    public  String sayHelloJsp(){
        return "sayHello";
    }
}
