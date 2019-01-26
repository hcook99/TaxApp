package com.harrisoncook.TaxInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * InfoController
 *
 * This class is used to control what web page is displayed.
 *
 * @author Harrison Cook
 * */
@Controller
public class InfoController {

    @GetMapping("/")
    public String gettingForm(Model model){
        Info info = new Info();
        model.addAttribute("taxInfo",info);
        return "welcome";
    }

    @PostMapping("/")
    public ModelAndView gettingSubmit(@ModelAttribute Info info){
        CalculateTax calculateTax = new CalculateTax(info.getTypes(),info.getIncome());
        double taxOwed = calculateTax.getRange();
        ModelAndView modelAndView = new ModelAndView("results");
        modelAndView.addObject("taxOwed", taxOwed);
        return modelAndView;
    }

}
