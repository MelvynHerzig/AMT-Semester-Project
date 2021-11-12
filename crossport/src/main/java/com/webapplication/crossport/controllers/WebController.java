package com.webapplication.crossport.controllers;

import com.webapplication.crossport.models.Article;
import com.webapplication.crossport.models.repository.ArticleRepository;
import com.webapplication.crossport.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired // This means to get the bean called userRepository. Which is auto-generated by Spring, we will use it to handle the data
    private ArticleRepository articleRepository;


    @GetMapping(value={"/", "/home", "/index.html"})
    public String greeting(HttpServletRequest request, @RequestParam(name="name", required=false, defaultValue="visitor") String name, Model model) {
        model.addAttribute("name", name);

        List<Integer> cartInfo = Cart.getCartInSession(request);
        cartInfo.add(1);
        cartInfo.add(2);

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){

        return "login";
    }

    @GetMapping("/shop")
    public String shop(HttpServletRequest request, Model model){

        Optional<Article> p = articleRepository.findById(1);

        p.ifPresent(article -> model.addAttribute("article", article));

        List<Integer> cartInfo = Cart.getCartInSession(request);
        for (int i : cartInfo) {
            System.out.println(i);
        }

        if(p.isPresent()){
            model.addAttribute("product", p.get());
        }

        return "shop";
    }

    @GetMapping("/cart")
    public String cart(HttpServletRequest request, Model model){


        return "cart";
    }

}
