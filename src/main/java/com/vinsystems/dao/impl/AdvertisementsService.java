package com.vinsystems.dao.impl;

import com.vinsystems.dao.IAdvertisements;
import com.vinsystems.entity.Ad;
import com.vinsystems.entity.AdvertisingHost;
import com.vinsystems.entity.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AdvertisementsService implements IAdvertisements {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Ad> getAllAdvertisements() {
        return null;
    }

    @Override
    public <T extends AdvertisingHost> List<T> getAllAdHosts(Class<T> hub) {
        Session session = entityManager.unwrap(Session.class);
        List<T> result = session.createQuery("SELECT a FROM BusAdHost a", hub).getResultList(); //should be updated to support different tables
        session.close();
        return result;
    }

    @Override
    public List<Ad> getAllAdvertisements(AdvertisingHost hub) {
        return null;
    }

    @Override
    public List<Ad> getAdvertisements(Customer customer) {
        return null;
    }

    @Override
    public List<Ad> getAllAdvertisementsByType(Class<? extends Ad> advertisementTypeClass) {
        return null;
    }
}
