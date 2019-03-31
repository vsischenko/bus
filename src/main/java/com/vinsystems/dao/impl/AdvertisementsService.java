package com.vinsystems.dao.impl;

import com.vinsystems.dao.IAdvertisements;
import com.vinsystems.dto.AdvertisementDTO;
import com.vinsystems.dto.AdvertisingHostDTO;
import com.vinsystems.dto.CustomerDTO;

import java.util.List;

public class AdvertisementsService implements IAdvertisements {

    @Override
    public List<AdvertisementDTO> getAllAdvertisements() {
        return null;
    }

    @Override
    public List<AdvertisementDTO> getAllAdvertisements(AdvertisingHostDTO hub) {
        return null;
    }

    @Override
    public List<AdvertisementDTO> getAdvertisements(CustomerDTO customer) {
        return null;
    }

    @Override
    public List<AdvertisementDTO> getAllAdvertisementsByType(Class<? extends AdvertisementDTO> advertisementTypeClass) {
        return null;
    }
}
