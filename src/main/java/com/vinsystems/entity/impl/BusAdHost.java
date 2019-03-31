package com.vinsystems.entity.impl;

import com.vinsystems.entity.AdvertisingHost;
import com.vinsystems.entity.impl.old.SpecialMarks;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "BusAdHost")
public class BusAdHost implements AdvertisingHost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String carPark;
    @Column
    private Integer routeNumber;
    @Column(name = "registrationNumber")
    private String registrationNumber;
    @Column
    private String model;
    @Column
    private String comment;
    @Column
    private String color;
    @Enumerated(EnumType.STRING)
    @Column
    private Status status;
    @Column
    private boolean numTabOnFrontWindow;
    @Embedded
    private SpecialMarks specialMarks;
    @Column
    private LocalDateTime creationDate;
    @Column
    private LocalDateTime effectiveDate;
    @Column
    private LocalDateTime expirationDate;
    @Column
    private LocalDateTime lastUpdatedDate;
    @Column
    private LocalDateTime reviewDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarPark() {
        return carPark;
    }

    public void setCarPark(String carPark) {
        this.carPark = carPark;
    }

    public Integer getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(Integer routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isNumTabOnFrontWindow() {
        return numTabOnFrontWindow;
    }

    public void setNumTabOnFrontWindow(boolean numTabOnFrontWindow) {
        this.numTabOnFrontWindow = numTabOnFrontWindow;
    }

    public SpecialMarks getSpecialMarks() {
        return specialMarks;
    }

    public void setSpecialMarks(SpecialMarks specialMarks) {
        this.specialMarks = specialMarks;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    @Override
    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusAdHost busAdHost = (BusAdHost) o;
        return numTabOnFrontWindow == busAdHost.numTabOnFrontWindow &&
                Objects.equals(id, busAdHost.id) &&
                Objects.equals(carPark, busAdHost.carPark) &&
                Objects.equals(routeNumber, busAdHost.routeNumber) &&
                Objects.equals(registrationNumber, busAdHost.registrationNumber) &&
                Objects.equals(model, busAdHost.model) &&
                Objects.equals(comment, busAdHost.comment) &&
                Objects.equals(color, busAdHost.color) &&
                status == busAdHost.status &&
                Objects.equals(specialMarks, busAdHost.specialMarks) &&
                Objects.equals(creationDate, busAdHost.creationDate) &&
                Objects.equals(effectiveDate, busAdHost.effectiveDate) &&
                Objects.equals(expirationDate, busAdHost.expirationDate) &&
                Objects.equals(lastUpdatedDate, busAdHost.lastUpdatedDate) &&
                Objects.equals(reviewDate, busAdHost.reviewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carPark, routeNumber, registrationNumber, model, comment, color, status, numTabOnFrontWindow, specialMarks, creationDate, effectiveDate, expirationDate, lastUpdatedDate, reviewDate);
    }

    @Override
    public String toString() {
        return "BusAdHost{" +
                "id=" + id +
                ", carPark='" + carPark + '\'' +
                ", routeNumber=" + routeNumber +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", comment='" + comment + '\'' +
                ", color='" + color + '\'' +
                ", status=" + status +
                ", numTabOnFrontWindow=" + numTabOnFrontWindow +
                ", specialMarks=" + specialMarks +
                ", creationDate=" + creationDate +
                ", effectiveDate=" + effectiveDate +
                ", expirationDate=" + expirationDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
