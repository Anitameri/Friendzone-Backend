package com.equipobeta.friendzone.events;


import com.equipobeta.friendzone.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity

@Getter
@Setter


public class Event implements Serializable{

    @Serial
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private Date event_date;
    private Time hour;
    private String location;
    private float budget;
    private String description;
    private String image;

    @ManyToMany(mappedBy = "events")
    private Collection <User> members;

    @ManyToOne
    @JoinColumn(name="user_id, nulleable=false")
    private User owner;


    public Event(long l, String name, String location, String description, String image, String budget, String hour, String event_date, String members){

    }

    public Event(String name) {
        this.name = name;
        this.event_date = event_date;
        this.hour = hour;
        this.location = location;
        this.budget = budget;
        this.description = description;
        this.image = image;
        this.members = members;
        this.owner = owner;
    }

    public Event(String name, String location) {
        this.id = id;
        this.name = name;
        this.event_date = event_date;
        this.location = location;
        this.budget = budget;
        this.description = description;
        this.image = image;
        this.hour = hour;
    }

    public Event(String name, String location, String description) {
        this.name = name;
        this.event_date = event_date;
        this.location = location;
        this.budget = budget;
        this.description = description;
        this.image = image;
        this.hour = hour;
    }

}
