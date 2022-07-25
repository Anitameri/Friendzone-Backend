package com.equipobeta.friendzone.events;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;

@Getter
@Setter

public class EventDto {

    private String name, description;

    private String location, image;

    private float budget;

    private DateFormat event_date;

    private long user_id;

}
