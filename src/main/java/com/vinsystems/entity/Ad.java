package com.vinsystems.entity;

import java.time.LocalDateTime;

public interface Ad extends Viewable {

    //Broken, Active, in Store, Deleted, etc.
    String getStatus();

    LocalDateTime getEffectiveDate();

    LocalDateTime getExpirationDate();

}
