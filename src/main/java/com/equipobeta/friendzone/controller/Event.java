package com.equipobeta.friendzone.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.io.Serial;
import java.io.Serializable;


@Entity

@Getter
@Setter

public class Event implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String date;
    private String place;
    private int budget;
    private String description;
    private String Image;

    @ManyToMany
    @JsonIgnore

    private User user;

    public User getUser(){
        return user;
    };


}