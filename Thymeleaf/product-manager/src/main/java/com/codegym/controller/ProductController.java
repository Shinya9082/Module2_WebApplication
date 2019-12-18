package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import com.codegym.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private ProductService productService=new ProductServiceImpl();
    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index","products",productService.findAll());
    }
    @GetMapping("/product/create")
    public ModelAndView create(){
        return new ModelAndView("create","product",new Product());
    }
    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        product.setId((int)(Math.random() * 10000));
        productService.save(product);
        redirect.addFlashAttribute("success", "Saved product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView edit(@PathVariable int id) {
        return new ModelAndView("edit","product",productService.findById(id));
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Modified product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/delete")
    public ModelAndView delete(@PathVariable int id) {
        return new ModelAndView("delete","product",productService.findById(id));
    }
    @PostMapping("/product/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/{id}/view")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view","product",productService.findById(id));
    }
}
