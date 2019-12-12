package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConvertController {

    public static final String CONVERT = "convert";

    //    @GetMapping("/convert")
//    public String convertFrom( Model model){
//        model.addAttribute("usd",0);
//        model.addAttribute("rate",0);
//        return "convert";
//    }
//    @PostMapping("/convert")
//    public String convertMoney(@RequestParam("usd") String money, @RequestParam("rate") String rate, Model model){
//        try{
//            double usd= Double.parseDouble(money);
//            double rateEx=Double.parseDouble(rate);
//            model.addAttribute("result",usd*rateEx);
//        } catch (NumberFormatException ex){
//            model.addAttribute("result","Error");
//        }
//        model.addAttribute("usd",money);
//        model.addAttribute("rate",rate);
//        return "convert";
//    }
    @GetMapping("/convert")
    public ModelAndView convertForm(){
        ModelAndView modelAndView =new ModelAndView(CONVERT);
        modelAndView.addObject("usd",0);
        modelAndView.addObject("rate",0);
        modelAndView.addObject("result","");
        return modelAndView;
    }
    @PostMapping("/convert")
    public ModelAndView convert(@RequestParam("usd") String money, @RequestParam("rate") String rate){
        ModelAndView modelAndView =new ModelAndView(CONVERT);
        try{
            double usd= Double.parseDouble(money);
            double rateEx=Double.parseDouble(rate);
            modelAndView.addObject("result",usd*rateEx);
        } catch (NumberFormatException ex){
            modelAndView.addObject("result","Error");
        }
        modelAndView.addObject("usd",money);
        modelAndView.addObject("rate",rate);
        return modelAndView;
    }
}
