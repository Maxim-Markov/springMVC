package jm.security.example.controller;

import jm.security.example.model.User;
import jm.security.example.service.UserDetailsServiceImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {

    @GetMapping(value = "/")
    public String getHomePage() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/user")
    public String getUserPage(@AuthenticationPrincipal User user, ModelMap modelMap) {
        modelMap.addAttribute("user",user);
        return "user";
    }

    @GetMapping(value = "/admin")
    public String getAdminPage() {
        return "admin";
    }

}
