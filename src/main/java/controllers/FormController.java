package controllers;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

public class FormController {

    @GetMapping
    public String register(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
    @PostMapping("/register")
    public String register(@Validated @ModelAttribute("user")User user, BindingResult bindingResult){
        new User().validate(user,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "index";
        }
        return "result";
    }
}
