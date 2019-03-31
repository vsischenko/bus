package com.vinsystems.dao;

import com.vinsystems.dto.AdvertisingHostDTO;
import com.vinsystems.dto.AdvertisementDTO;
import com.vinsystems.dto.CustomerDTO;

import java.util.List;

/**
 * Interface for AdvertisementDTO service
 */
public interface IAdvertisements {

    /**
     * returns all Advertisements available in the system
     *
     * @return {@link List}<{@link AdvertisementDTO}>
     */
    List<AdvertisementDTO> getAllAdvertisements();

    /**
     * returns all Advertisements available in the system for specific {@link AdvertisingHostDTO}
     *
     * @return {@link List}<{@link AdvertisementDTO}>
     */
    List<AdvertisementDTO> getAllAdvertisements(AdvertisingHostDTO hub);

    /**
     * returns all Advertisements available in the system for specific {@link CustomerDTO}
     *
     * @return {@link List}<{@link AdvertisementDTO}>
     */
    List<AdvertisementDTO> getAdvertisements(CustomerDTO customer);

    /**
     * returns all Advertisements of specific type {@link AdvertisementDTO} available in the system
     *
     * @return {@link List}<{@link AdvertisementDTO}>
     */
    List<AdvertisementDTO> getAllAdvertisementsByType(Class<? extends AdvertisementDTO> advertisementTypeClass);

}
