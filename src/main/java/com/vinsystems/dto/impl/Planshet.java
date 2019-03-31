package com.vinsystems.dto.impl;

import com.vinsystems.dto.AdvertisementDTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Planshet implements AdvertisementDTO, Serializable {

    private static final long serialVersionUID = -350639818314699851L;

    @Override
    public LocalDateTime getReviewDate() {
        return null;
    }

    @Override
    public String getStatus() {
        return null;
    }

    @Override
    public LocalDateTime getEffectiveDate() {
        return null;
    }

    @Override
    public LocalDateTime getExpirationDate() {
        return null;
    }


    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void viewed() {
        update(); // update review date
    }
}
