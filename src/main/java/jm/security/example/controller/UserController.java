package jm.security.example.controller;


import jm.security.example.model.User;
import jm.security.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUserPage(@AuthenticationPrincipal User user, ModelMap modelMap) {
        User userFromDB = (User) userService.loadUserByUsername(user.getUsername());
        modelMap.addAttribute("user", userFromDB);
        return "user";
    }
}
