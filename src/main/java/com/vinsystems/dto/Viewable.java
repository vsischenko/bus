package com.vinsystems.dto;


import java.time.LocalDateTime;

/**
 * Common interface for all objects what needs to be updated as "viewed".
 * i.e. after smbdy checked that everything is fine, he should update status of the inspected object.
 * Current interface exactly focused on mentioned status update.
 */
public interface Viewable {

    void viewed();

    LocalDateTime getReviewDate(); //get last date when was viewed

}
