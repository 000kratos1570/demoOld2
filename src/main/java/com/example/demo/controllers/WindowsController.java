package com.example.demo.controllers;

import com.example.demo.models.Windows;
import com.example.demo.repository.WindowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WindowsController {

    @Autowired
    private WindowsRepository windowsRepository;

    @GetMapping("/windows")
    public String windowMain(Model model) {
        Iterable<Windows> windows = windowsRepository.findAll();
        model.addAttribute("windows",windows);
        return "windows-main";
    }

    @GetMapping("/windows/add")
    public String windowsAdd(Model model) {
        return "windows-add";
    }

    @PostMapping("/windows/add")
    public String windowsPostAdd(@RequestParam String name,
                               @RequestParam String material,
                               @RequestParam int width,
                               @RequestParam int height,
                               @RequestParam(required=false) boolean insulation, Model model)
    {
        Windows windows = new Windows(name,material,width,height,insulation);
        windowsRepository.save(windows);
        return "redirect:/windows";
    }

    @GetMapping("/windows/filter")
    public String windowsfilter(Model model) {
        return "windows-filter";
    }

    @PostMapping("/windows/filter/result")
    public String windowsResult(@RequestParam String name, Model model)
    {
        if(name != null){
            List<Windows> windows = windowsRepository.findByname(name);
            model.addAttribute("windows", windows);
        }
        return "windows-filter";
    }
}
