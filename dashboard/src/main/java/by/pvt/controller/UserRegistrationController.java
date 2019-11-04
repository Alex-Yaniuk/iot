package by.pvt.controller;

import by.pvt.pojo.AppUser;
import by.pvt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegisterForm(Model model) {
        return "user/registration";
    }

    @PostMapping
    public String registerForm(@ModelAttribute AppUser user) {
        userService.registerNewUser(user);
        return "redirect:/login";
    }
}
