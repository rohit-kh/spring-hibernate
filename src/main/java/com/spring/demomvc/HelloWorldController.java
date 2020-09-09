package com.spring.demomvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showFrom(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String processFormV2(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();

        model.addAttribute("message", "Yo! " + theName);
        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String processFormV3(@RequestParam("studentName") String theName, Model model){
        theName = theName.toUpperCase();
        model.addAttribute("message", "Hey My Friend from v3! " + theName);
        return "helloworld";
    }
}
