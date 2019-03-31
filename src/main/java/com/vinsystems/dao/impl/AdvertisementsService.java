package com.vinsystems.dao.impl;

import com.vinsystems.dao.IAdvertisements;
import com.vinsystems.entity.Ad;
import com.vinsystems.entity.AdvertisingHost;
import com.vinsystems.entity.Customer;

import java.util.List;

public class AdvertisementsService implements IAdvertisements {

    @Override
    public List<Ad> getAllAdvertisements() {
        return null;
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
