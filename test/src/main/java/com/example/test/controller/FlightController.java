package com.example.test.controller;

import com.example.test.entity.Flight;
import com.example.test.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("flight", new Flight());
        model.addAttribute("flights", service.findAll());
        return "index";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Flight flight) {
        service.save(flight);
        return "redirect:/flights/index";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Flight flight) {
        service.save(flight);
        return "redirect:/flights/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("flight", service.findById(id).orElse(new Flight()));
        model.addAttribute("flights", service.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteById(id);
        return "redirect:/flights/index";
    }


    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("flights", service.search(keyword));
        model.addAttribute("flight", new Flight());
        return "index";
    }
}
