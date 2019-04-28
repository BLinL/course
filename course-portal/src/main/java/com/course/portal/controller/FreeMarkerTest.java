package com.course.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FreeMarkerTest {

    @RequestMapping("hello")
    public String sayHello(ModelMap modelMap){
        modelMap.addAttribute("name","bliu");
        modelMap.addAttribute("say","hello ");
        return "hello";
    }
}
