package com.example.thymeleafcheckboxdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j
public class FormController {

    private static boolean isChecked = false;

    @GetMapping
    public String getForm(Model model) {
        log.info("Check status: {}",isChecked);
        model.addAttribute("form", new Form());
        return "index";
    }

    @PostMapping
    public String postForm(@ModelAttribute Form form) {

        isChecked = form.isChecked();

        log.info("Is form checked: {}",isChecked);

        return "redirect:/";
    }
}
