package com.mano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @GetMapping("/")
    public ModelAndView index(final Model model) {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("title", "<<I have built a sprint boot application using Maven>>");
        mv.addObject("msg", "<<This application is deployed on to Kubernetes using Argo CD>>");
        return mv;
    }
}
