package com.vinsystems.controllers;


import com.vinsystems.dao.impl.AdvertisementsService;
import com.vinsystems.entity.impl.BusAdHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private AdvertisementsService advertisementsService;

    @GetMapping("/busHostView")
    public ModelAndView getAllBusHosts() {
        return new ModelAndView("busHostsView", "busAdHostList", advertisementsService.getAllAdHosts(BusAdHost.class));
    }

}
