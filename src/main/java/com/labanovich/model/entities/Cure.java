package com.labanovich.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cure {
    private int id;
    private String name;
    private String type;
    private String dose;
    private String deliveryTime;
    private String description;
    private double price;
    private int basketCureId;


    public Cure(int id, String name, String type, String dose, String deliveryTime, String description, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dose = dose;
        this.deliveryTime = deliveryTime;
        this.description = description;
        this.price = price;
    }
}
