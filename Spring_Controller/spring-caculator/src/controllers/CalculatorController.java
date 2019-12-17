package controllers;

import Model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView viewCalculator(){
        ModelAndView modelAndView = new ModelAndView("calculator");
        modelAndView.addObject("num1", 0);
        modelAndView.addObject("num2", 0);
        modelAndView.addObject("result", "");
        return modelAndView;
    }
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public ModelAndView doMath(@RequestParam("operator")String operator,
                               @RequestParam("num1")String num1,
                               @RequestParam("num2")String num2){
        System.out.println(operator);
        System.out.println(num1+"  "+num2);
        ModelAndView modelAndView = new ModelAndView("calculator");
        Object result= Calculator.doScript(num1+operator+num2+"");
        modelAndView.addObject("num1",num1);
        modelAndView.addObject("num2",num2);
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
