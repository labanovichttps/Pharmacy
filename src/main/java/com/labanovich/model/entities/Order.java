package com.labanovich.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    private int id;
    private int user_id;
    private String initials;
    private String email;
    private double total;
    private Timestamp orderDate;

    public Order(int id, String initials, String email, double total, Timestamp orderDate) {
        this.id = id;
        this.initials = initials;
        this.email = email;
        this.total = total;
        this.orderDate = orderDate;
    }
}
