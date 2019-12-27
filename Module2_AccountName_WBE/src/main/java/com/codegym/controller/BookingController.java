package com.codegym.controller;

import com.codegym.model.ResortService;
import com.codegym.service.ResortService_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {
    @Autowired
    ResortService_Service resortService;

    @GetMapping("/")
    public ModelAndView showHome(){
        return new ModelAndView("views/index","services",resortService.getAllResortService());
    }
    @GetMapping("/booking/{id}")
    public ModelAndView bookService(@PathVariable("id") Long id){
        ResortService service=resortService.getResortService(id);
        if(service==null){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("views/book_service","service",service);
    }

    @GetMapping("/login")
    public ModelAndView showLogin(){
        return new ModelAndView("views/login");
    }
    @GetMapping("/about")
    public ModelAndView showAbout(){
        return new ModelAndView("views/about")   ;
    }
}
