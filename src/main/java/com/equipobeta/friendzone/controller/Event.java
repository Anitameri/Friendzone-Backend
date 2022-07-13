package com.equipobeta.friendzone.controller;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.awt.*;
import java.io.Serial;

public class Event {
}

@Entity

@Getter
@Setter

public class Event implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date
    private Place
    private int Budget
    private String Description
    private Image
}