package com.airtickets.airtickets.controlers;

import com.airtickets.airtickets.controlers.domain.Tickets;
import com.airtickets.airtickets.repos.SellerRepo;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SellerController {
    @Autowired
    private SellerRepo sellerRepo;

    @GetMapping("/tickets")
    public String ticketss(Map<String, Object> model) {

        Iterable<Tickets> tickets = sellerRepo.findAll();

        model.put("tickets",tickets);

        return "ticketSeller";
    }


    @PostMapping("/tickets")
    public String add(@RequestParam String text,@RequestParam String tag,@RequestParam String country, Map<String, Object> model){
      Tickets ticket = new Tickets(text, tag, country);

      sellerRepo.save(ticket);

      Iterable<Tickets> tickets = sellerRepo.findAll();

      model.put("tickets",tickets);

      return "ticketSeller";
    }




}
