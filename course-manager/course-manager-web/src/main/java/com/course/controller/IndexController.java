package com.course.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {




    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView();
    }

//    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(IndexController.class);
//        logger.info("你是谁" +
//                "");
//    }
}
