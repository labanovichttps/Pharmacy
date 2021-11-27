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
}
