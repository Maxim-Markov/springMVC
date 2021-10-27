package jm.security.example.controller;

import jm.security.example.model.User;
import jm.security.example.service.UserDetailsServiceImpl;
import jm.security.example.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping(value = "/")
    public String getUserPage(@AuthenticationPrincipal User user, ModelMap modelMap) {
        UserDetails user2 = new UserDetailsServiceImpl().loadUserByUsername(user.getUsername());
        modelMap.addAttribute("user",user2);
        return "user";
    }
}
