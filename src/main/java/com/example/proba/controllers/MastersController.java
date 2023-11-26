package com.example.proba.controllers;

import com.example.proba.models.Masters;
import com.example.proba.services.MastersService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@AllArgsConstructor
public class MastersController {

    private final MastersService mastersService;

    @GetMapping("/infomasters")
    public String masters(@RequestParam(name="fullname",required = false) String fullname, Model model) {
        model.addAttribute("masters", mastersService.mastersList(fullname));
        return "infomasters";
    }

    @GetMapping("/addmaster")
    public String mastersview() {
        return "masters";
    }

    @PostMapping("/addmasters")
    public String addMaster(@ModelAttribute("master") Masters master,
                            @RequestParam("photo") MultipartFile photo) throws IOException {
        mastersService.addMasters(master, photo);
        return "redirect:/infomasters";
    }
}
