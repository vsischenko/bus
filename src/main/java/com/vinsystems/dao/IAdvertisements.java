package com.vinsystems.dao;

import com.vinsystems.entity.Ad;
import com.vinsystems.entity.AdvertisingHost;
import com.vinsystems.entity.Customer;

import java.util.List;

/**
 * Interface for Ad service
 */
public interface IAdvertisements {

    /**
     * returns all Advertisements available in the system
     *
     * @return {@link List}<{@link Ad}>
     */
    List<Ad> getAllAdvertisements();

    //temporary placement, will be moved to adHost service interface
    <T extends AdvertisingHost> List<T> getAllAdHosts(Class<T> hub);

    /**
     * returns all Advertisements available in the system for specific {@link AdvertisingHost}
     *
     * @return {@link List}<{@link Ad}>
     */
    List<Ad> getAllAdvertisements(AdvertisingHost hub);

    /**
     * returns all Advertisements available in the system for specific {@link Customer}
     *
     * @return {@link List}<{@link Ad}>
     */
    List<Ad> getAdvertisements(Customer customer);

    /**
     * returns all Advertisements of specific type {@link Ad} available in the system
     *
     * @return {@link List}<{@link Ad}>
     */
    List<Ad> getAllAdvertisementsByType(Class<? extends Ad> advertisementTypeClass);

}
