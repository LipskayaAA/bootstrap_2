package com.lipskaya.bootstrap.controller;

import com.lipskaya.bootstrap.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.annotation.CurrentSecurityContext;
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String showUserInfo(@CurrentSecurityContext(expression = "authentication.principal") User principal,
                               Model model) {
        model.addAttribute("user", principal);
        return "fragments/user-info";
    }
}