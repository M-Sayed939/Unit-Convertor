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
@RequestMapping("/length")
public class LenghtController {
    @Autowired
    private ConversionService conversionService;

    @PostMapping
    public String convertLength(@RequestParam("value") double value,
                                @RequestParam("from") String from,
                                @RequestParam("to") String to,
                                Model model) {
        double result = conversionService.convertLength(value, from, to);
        model.addAttribute("result", result);
        model.addAttribute("from", from);
        model.addAttribute("to", to);
        return "length";

    }

    @GetMapping
    public String showLengthForm() {
        return "lenght";
    }
}
