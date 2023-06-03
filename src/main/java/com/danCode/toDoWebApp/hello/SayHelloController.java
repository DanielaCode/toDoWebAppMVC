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

    @RequestMapping("say-hello-html")
    @ResponseBody
    public  String sayHelloHtml(){
        //return strings is not considered efficient so go for stringBuilder or string buffer
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
}
