package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @Valid @ModelAttribute User user, String verify, Errors errors) {
        //model.addAttribute("user", user);
        model.addAttribute(new User());
        model.addAttribute("verify", verify);
        //model.addAttribute("username", user.getUsername());
        //model.addAttribute("email", user.getEmail());

        if (user.getPassword().equals(verify) && !errors.hasErrors()) {
           return "user/index";
        }
        else {
            model.addAttribute("error", "Passwords do not match" );
            return "user/add";
        }

    }


}
