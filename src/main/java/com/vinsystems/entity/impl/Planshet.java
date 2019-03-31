package com.vinsystems.entity.impl;

import com.vinsystems.entity.Ad;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Planshet implements Ad, Serializable {

    private static final long serialVersionUID = -350639818314699851L;

    @Override
    public void setReviewDate(LocalDateTime date) {

    }

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


}
