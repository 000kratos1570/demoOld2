package com.example.demo.controllers;

import com.example.demo.models.Gachi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repository.GachiRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private GachiRepository gachiRepository;

    @GetMapping("/")
    public String gachiMain(Model model) {
        Iterable<Gachi> gachis = gachiRepository.findAll();
        model.addAttribute("gachi", gachis);
        return "Gachi-main";
    }

    @GetMapping("/gachi/add")
    public String gachiAdd(Model model) {
        return "gachi-add";
    }

    @PostMapping("/gachi/add")
    public String gachiPostAdd(@RequestParam String titlegachi,
                              @RequestParam String massagegachi,
                              @RequestParam String scream,
                              @RequestParam int countAss,
                               @RequestParam int views, Model model)
    {
        Gachi gachi = new Gachi(titlegachi,massagegachi,scream,countAss,views);
        gachiRepository.save(gachi);
        return "redirect:/";
    }

    @GetMapping("/gachi/filter")
    public String gachifilter(Model model) {
        return "gachi-filter";
    }

    @PostMapping("/gachi/filter/result")
    public String gachiResult(@RequestParam String titlegachi, Model model)
    {
        if(titlegachi != null){
            List<Gachi> gachis = gachiRepository.findBytitlegachi(titlegachi);
            model.addAttribute("gachi", gachis);
        }
        return "gachi-filter";
    }
//
//    @GetMapping("/blog/{id}")
//    public String blogDetails(@PathVariable(value = "id") long id, Model model)
//    {
//        Optional<Gachi> post = postRepository.findById(id);
//        ArrayList<Gachi> res = new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("post", res);
//        if(!postRepository.existsById(id))
//        {
//            return "redirect:/blog";
//        }
//        return "blog-details";
//    }
//
//    @GetMapping("/blog/{id}/edit")
//    public String blogEdit(@PathVariable(value = "id") long id, Model model)
//    {
//        if(!postRepository.existsById(id))
//        {
//            return "redirect:/";
//        }
//        Optional<Gachi> post = postRepository.findById(id);
//        ArrayList<Gachi> res = new ArrayList<>();
//        post.ifPresent(res::add);
//        model.addAttribute("post", res);
//        return "blog-edit";
//    }
//
//    @PostMapping("/blog/{id}/edit")
//    public String blogPostUpdate (@PathVariable("id")long id,
//                                  @RequestParam String title,
//                                  @RequestParam String anons,
//                                  @RequestParam String full_text,
//                                  Model model)
//    {
//        Gachi post = postRepository.findById(id).orElseThrow();
////        post.setTitle(title);
////        post.setAnons(anons);
////        post.setFull_text(full_text);
//        postRepository.save(post);
//        return "redirect:/";
//    }
//
//    @PostMapping("/blog/{id}/remove")
//    public String blogBlogDelete(@PathVariable("id")long id, Model model){
//        Gachi post = postRepository.findById(id).orElseThrow();
//        postRepository.delete(post);
//        return "redirect:/";
//    }
}