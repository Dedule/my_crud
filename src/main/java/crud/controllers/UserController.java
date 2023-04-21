package crud.controllers;

import crud.models.User;
import crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @GetMapping("/index")
    public String cars(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("usersList", us.getUserList());
        return "index";
    }

    @PostMapping("/index")
    public String create(@ModelAttribute("user") User user) {
        us.save(user);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", us.show(id));
        return "/edit";
    }

    @PatchMapping("/edit/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        us.update(id, user);
        return "redirect:/index";
    }

    @DeleteMapping("/edit/{id}")
    public String delete(@PathVariable("id") Long id) {
        us.delete(id);
        return "redirect:/index";
    }
}
