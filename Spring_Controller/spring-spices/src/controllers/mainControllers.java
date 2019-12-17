package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainControllers {
    @GetMapping("/")
    public String display(){
        return "index";
    };
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(required=false,name = "list") String []listChecked){
        StringBuilder message= new StringBuilder();
        ModelAndView modelAndView=new ModelAndView("save");
        if (listChecked!=null){
            message = new StringBuilder("Checked spices: ");
            for (String spice: listChecked
                 ) {
                if(spice!=null){
                    message.append(spice).append(", ");
                }
            }
            message.replace(message.length()-2, message.length(),"");
        }else {
            message.append("Non-exist");
        }
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
