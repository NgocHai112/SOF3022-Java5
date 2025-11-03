package com.example.ps43664java5.controller;

import com.example.ps43664java5.entity.User;
import com.example.ps43664java5.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        return "user/index";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "user/index";
        }
        userService.save(user);
        return "redirect:/user/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("users", userService.findAll());
        return "user/index";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user,
                         BindingResult result,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "user/index";
        }
        userService.save(user);
        return "redirect:/user/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        userService.delete(id);
        return "redirect:/user/index";
    }

    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.search(keyword));
        return "user/index";
    }
}
