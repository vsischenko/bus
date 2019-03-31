package com.vinsystems.controllers;

import com.vinsystems.entity.impl.BusAdHost;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    private EntityManager entityManager; //temporary placement to check hibernate work in H2

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
        Session session = entityManager.unwrap(Session.class);
        session.save(test);
        session.save(test2);
        session.save(test3);// all above hardcoded to check UI representation and mapping to html page
        return new ModelAndView("busHostsView", "busAdHostList", busAdHostList);
    }


}