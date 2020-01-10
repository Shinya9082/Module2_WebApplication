package com.codegym.module2_test.controller;

import com.codegym.module2_test.models.City;
import com.codegym.module2_test.models.Nation;
import com.codegym.module2_test.service.CityService;
import com.codegym.module2_test.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    CityService cityService;

    @Autowired
    NationService nationService;
    @ModelAttribute("nations")
    public Iterable<Nation> nations(){
        return nationService.findAll();
    }

    @GetMapping({"/city/list","/"})
    public ModelAndView listCity(Pageable pageable) {
        Page<City> cities;
        cities= cityService.findAll(pageable);
        return new ModelAndView("city/list", "cities", cities);
    }
    @GetMapping("city/list/{name}")
    public ModelAndView listCityByFirstName(Pageable pageable, @PathVariable String name) {
        Page<City> cities;
        Nation nation=nationService.findByName(name);
        cities=cityService.findAllByNation(nation,pageable);
        ModelAndView modelAndView=new ModelAndView("city/list", "cities", cities);
        modelAndView.addObject("name",name);
        return modelAndView;
    }
    @PostMapping("city/list")
    public String listCityByFirstName(@RequestParam(name = "s1") String name) {
        return "redirect:/city/list/"+name;
    }

    @GetMapping("/city/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/city/create")
    public ModelAndView saveCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("city/create");
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công");
        return new ModelAndView("redirect:/city/list");
    }
    @GetMapping("/city/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        }else {
            return new ModelAndView("city/error404");
        }
    }
    @PostMapping("/city/edit")
    public ModelAndView updateCity(@Validated @ModelAttribute("city") City city,BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("city/edit");
        }
        cityService.save(city);
        redirectAttributes.addFlashAttribute("message", "Cập nhập thành công");
        return new ModelAndView("redirect:/city/list");
    }
    @GetMapping("/city/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("city/delete");
            modelAndView.addObject("city", city);
            return modelAndView;
        }else {
            return new ModelAndView("city/error404");
        }
    }
    @GetMapping("/city/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id){
        City city = cityService.findById(id);
        if(city != null) {
            ModelAndView modelAndView = new ModelAndView("city/view");
            modelAndView.addObject("city", city);
            return modelAndView;
        }else {
            return new ModelAndView("city/error404");
        }
    }

    @PostMapping("/city/delete")
    public String deleteCity(@ModelAttribute("city") City city,RedirectAttributes redirectAttributes){
        cityService.remove(city.getId());
        redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        return "redirect:/city/list";
    }
}
