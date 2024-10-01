package org.example.unitconverter.controllers;

import org.example.unitconverter.services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weight")
public class WeightController {
    @Autowired
    private ConversionService conversionService;

    @PostMapping
    public String convertWeight(@RequestParam double value, @RequestParam String from, @RequestParam String to, Model model) {
        double result = conversionService.convertWeight(value, from, to);
        model.addAttribute("result", result);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "weight";
    }

    @GetMapping
    public String showWeightForm() {
        return "weight";
    }

}
