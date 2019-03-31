package com.vinsystems.dto;

import java.time.LocalDateTime;

public interface AdvertisementDTO extends Viewable, CommonActionsDTO {

    //Broken, Active, in Store, Deleted, etc.
    String getStatus();

    LocalDateTime getEffectiveDate();

    LocalDateTime getExpirationDate();

}
