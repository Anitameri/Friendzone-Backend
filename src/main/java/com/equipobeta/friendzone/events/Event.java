package com.equipobeta.friendzone.events;


import com.equipobeta.friendzone.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.text.DateFormat;
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
    private DateFormat event_date;
    private String location;
    private float budget;
    private String description;
    private String image;

    @ManyToMany(mappedBy = "events")
    private Collection <User> members;

    @ManyToOne
    @JoinColumn(name="user_id, nulleable=false")
    private User owner;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Event(){

    }

    public Event(Long id, String name, DateFormat event_date, String location, float budget, String description, String image) {
        this.id = id;
        this.name = name;
        this.event_date = event_date;
        this.location = location;
        this.budget = budget;
        this.description = description;
        this.image = image;
    }

    public Event(String name, DateFormat event_date, String location, float budget, String description, String image) {
        this.name = name;
        this.event_date = event_date;
        this.location = location;
        this.budget = budget;
        this.description = description;
        this.image = image;
    }
}
