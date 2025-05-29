package com.nuos.lr9.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.nuos.lr9.service.Tabulation;

@Controller
public class TabulationController {
    private final Tabulation tabulation = new Tabulation();

    @GetMapping("/")
    public String showForm() {
        return "tabulation";
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam double start,
            @RequestParam double end,
            @RequestParam double step,
            @RequestParam double a,
            @RequestParam double b,
            Model model) {

        double[] arguments = tabulation.generateArguments(start, end, step);
        double[] values = tabulation.calculateValues(arguments, a, b);

        int minIndex = tabulation.findMinIndex(values);
        int maxIndex = tabulation.findMaxIndex(values);
        double sum = tabulation.sum(values);
        double average = tabulation.average(values);

        int[] testIndexes = {175, 350, 750};

        model.addAttribute("arguments", arguments);
        model.addAttribute("values", values);
        model.addAttribute("minIndex", minIndex);
        model.addAttribute("maxIndex", maxIndex);
        model.addAttribute("sum", sum);
        model.addAttribute("average", average);
        model.addAttribute("testIndexes", testIndexes);
        model.addAttribute("a", a);
        model.addAttribute("b", b);

        return "tabulation";
    }
}