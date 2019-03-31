package com.vinsystems.controllers;

import com.vinsystems.entity.impl.BusAdHost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", "World");
        return "/greeting";
    }

    @GetMapping(value = "/getAllBusHosts")
    public ModelAndView getAllBusHosts() {
        BusAdHost test = new BusAdHost();
        test.setCarPark("Test Park 1");
        test.setModel("Bogdan");
        BusAdHost test2 = new BusAdHost();
        test2.setCarPark("Test Park 2");
        test2.setModel("Bogdan2");
        BusAdHost test3 = new BusAdHost();
        test3.setCarPark("Test Park 3");
        test3.setModel("Bogdan3");
        List<BusAdHost> busAdHostList = new ArrayList<>();
        busAdHostList.add(test);
        busAdHostList.add(test2);
        busAdHostList.add(test3);
        return new ModelAndView("busHostsView", "busAdHostList", busAdHostList);
    }


}