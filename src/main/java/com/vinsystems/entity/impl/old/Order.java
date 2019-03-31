package com.vinsystems.entity.impl.old;

import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column
    String nameOfClient;
    @Column
    String nameOfOrder;

    public int getId() {
        return id;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public String getNameOfOrder() {
        return nameOfOrder;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameOfClient(String nameOfClient) {
        this.nameOfClient = nameOfClient;
    }

    public void setNameOfOrder(String nameOfOrder) {
        this.nameOfOrder = nameOfOrder;
    }
}
