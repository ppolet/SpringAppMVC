package org.example.springcourse17.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first") //название может быть любым и URL, соответственно поменяется: http://localhost:8080/first/hello
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              Model model){

        //System.out.println("GoodBye, " + name + " " + surname);
        model.addAttribute("message", "GoodBye, " + name + " " + surname);

        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,
                             Model model){

        double result = 0;

        if(action.equals("mult")){
            result = a * b;
        } else if (action.equals("add")){
            result = a + b;
        } else if (action.equals("substr")){
            result = a - b;
        } else if (action.equals("div")){
            result = (double)a / b;
        }

        model.addAttribute("message", "Calculator: " + a + " " + action + " " + b + " = " + result);

        return "first/calculator";

    }
}
