package com.example.ps43664java5.controller;

import com.example.ps43664java5.entity.User;
import com.example.ps43664java5.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // === LOAD TRANG CHÍNH ===
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        return "user/index";
    }

    // === CREATE ===
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttrs) {
        if (user.getAdmin() == null) user.setAdmin(false);
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "user/index";
        }
        userService.save(user);
        redirectAttrs.addFlashAttribute("success", "Thêm người dùng thành công!");
        return "redirect:/user/index";
    }

    // === EDIT (load user lên form) ===
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user != null ? user : new User());
        model.addAttribute("users", userService.findAll());
        return "user/index";
    }

    // === UPDATE ===
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttrs) {
        if (user.getAdmin() == null) user.setAdmin(false);
        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            return "user/index";
        }

        User old = userService.findById(user.getId());
        if (old != null && (user.getPassword() == null || user.getPassword().isBlank())) {
            user.setPassword(old.getPassword());
        }

        userService.save(user);
        redirectAttrs.addFlashAttribute("success", "Cập nhật người dùng thành công!");
        return "redirect:/user/index";
    }

    // === DELETE TỪ FORM ===
    @PostMapping("/delete-form")
    public String deleteFromForm(@ModelAttribute("user") User user,
                                 RedirectAttributes redirectAttrs) {
        if (user.getId() != null && !user.getId().isBlank()) {
            userService.delete(user.getId());
            redirectAttrs.addFlashAttribute("success", "Đã xóa người dùng!");
        }
        return "redirect:/user/index";
    }

    // === DELETE TRỰC TIẾP (ở bảng) ===
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id,
                         RedirectAttributes redirectAttrs) {
        userService.delete(id);
        redirectAttrs.addFlashAttribute("success", "Đã xóa người dùng!");
        return "redirect:/user/index";
    }

    // === SEARCH ===
    @PostMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.search(keyword));
        return "user/index";
    }
}
