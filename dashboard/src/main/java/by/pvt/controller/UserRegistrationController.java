package by.pvt.controller;

import by.pvt.model.AppUser;
import by.pvt.service.UserService;
import by.pvt.util.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRegistrationValidator userRegistrationValidator;

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user",new AppUser());
        return "user/registration";
    }

    @PostMapping
    public String registerForm(@ModelAttribute("user") AppUser user, BindingResult result) {
        userRegistrationValidator.validate(user, result);
        if (result.hasErrors()) {
            return "user/registration";
        }
        userService.registerNewUser(user);
        return "redirect:/login";
    }
}
