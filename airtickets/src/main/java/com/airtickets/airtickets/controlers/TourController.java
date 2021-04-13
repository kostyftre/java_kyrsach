package com.airtickets.airtickets.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TourController {

    @GetMapping("/tours")
    public String tickets(Model model){
        return "tour";
    }

}
