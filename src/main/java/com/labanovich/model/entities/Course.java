package com.labanovich.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private int id;
    private String title;
    private String subtitle;
    private String description;
    private Date date;
    private String place;
    private String author;
    private Status status;
    private Type type;
    private int user_id;
}
