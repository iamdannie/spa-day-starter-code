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
    @GetMapping
    public String displayAddUserForm() {
        return "user/add";
    }
@PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword){
//   if password & verify password aren't the same model.add displays an error to users, else model.add Welcome in user/index.html
    if (!verifyPassword.equals(user.getPassword())){
        model.addAttribute("Error" , "Password Doesn't Match");
        return "user/add";
    } else {
        model.addAttribute("user", user);
        return "user/index";
    }

}


}
