package com.vinsystems.controllers;

import com.vinsystems.dao.impl.AdvertisementsService;
import com.vinsystems.entity.impl.BusAdHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;


@Controller
public class BusHostController {

    @Autowired
    private AdvertisementsService advertisementsService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping(value = "/createBusView")
    public ModelAndView createBusView() {
        return new ModelAndView("createBusView", "busAdHost", new BusAdHost());
    }

    @PostMapping(value = "/createBus")
    public ModelAndView createBus(@ModelAttribute BusAdHost busAdHost) {
        EntityManager manager = entityManager.getEntityManagerFactory().createEntityManager();
        manager.getTransaction().begin();
        manager.persist(busAdHost);
        manager.getTransaction().commit();
        return new ModelAndView("busHostsView", "busAdHostList", advertisementsService.getAllAdHosts(BusAdHost.class));
    }

}