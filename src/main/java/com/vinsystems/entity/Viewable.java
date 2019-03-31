package com.vinsystems.entity;


import java.time.LocalDateTime;

/**
 * Common interface for all objects what needs to be updated as "setReviewDate".
 * i.e. after smbdy checked that everything is fine, he should update status of the inspected object.
 * Current interface exactly focused on mentioned status update.
 */
public interface Viewable {

    void setReviewDate(LocalDateTime date);

    LocalDateTime getReviewDate(); //get last date when was setReviewDate

}
