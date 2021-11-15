package com.webapplication.crossport.controllers;

import com.webapplication.crossport.models.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController {

    @GetMapping(value={"/", "/home", "/index.html"})
    public String greeting(HttpServletRequest request, @RequestParam(name="name", required=false, defaultValue="visitor") String name, Model model) {
        model.addAttribute("name", name);

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){

        return "login";
    }
}
