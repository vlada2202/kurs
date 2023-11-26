package com.example.proba.controllers;

import com.example.proba.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.proba.models.User;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/autorisation")
    public String login(Principal principal,Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "autorisation";
    }

    @GetMapping("/registration")
    public String registration(Principal principal,Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
    return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model){
        if (!userService.createUser(user))
        {
            model.addAttribute("errorMessage","Пользователь с email:"+ user.getEmail()+" уже существует");
            return "registration";
        }
        return "redirect:/autorisation";
    }
    @GetMapping("/user/{user}")
    public String userInfo(@PathVariable("user") User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "user-info";
    }
}
