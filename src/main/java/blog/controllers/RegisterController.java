package blog.controllers;

import blog.forms.RegisterForm;
import blog.models.User;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by albertkurnia on 7/25/2017.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm) {
        return "users/register";
    }

    @RequestMapping(value = "users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        if (userService.checkIfUsernameExist(registerForm.getUsername())) {
            notifyService.addErrorMessage("Username is already taken!");
            return "users/register";
        }

        User user = new User(registerForm.getFullName(), registerForm.getUsername(), registerForm.getPassword());
        userService.create(user);
        notifyService.addInfoMessage("Success to save");
        return "redirect:/";
    }
}
