package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("user/add")
    public String displayAddUserForm(Model model, String userName, String email, String password){
        return "/user/add.html";
    }
    @PostMapping("user/add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here, create an if statement to check that veridy matches user.password, if yes,
        //render user/index.html, if no, return "use/add.html";
        if (verify.equals(user)){
            return "user/index";
        } else {
            model.addAttribute("error");
            model.addAttribute("thisUsername");
            model.addAttribute("thisEmail");
            return "/user/add.html";
        }



    }


}
