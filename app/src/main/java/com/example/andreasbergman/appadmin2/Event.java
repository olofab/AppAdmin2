package com.example.andreasbergman.appadmin2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by andreasbergman on 20/10/16.
 */

public class Event implements Serializable {

    private String name;
    private String description;
    private int participants;
    private int dinnerParticipants;
    private static int eventId = 0;
    private String date;

    private ArrayList<Participants> attendingParticipants;

    public Event (){
        attendingParticipants = new ArrayList<Participants>();
    }

    public Event(String name, String description, int participants, String date, int dinnerParticipants) {
        eventId++;
        this.name = name;
        this.description = description;
        this.participants = participants;
        this.date = date;
        this.dinnerParticipants = dinnerParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public int getDinnerParticipants() {
        return dinnerParticipants;
    }

    public void setDinnerParticipants(int dinnerParticipants) {
        this.dinnerParticipants = dinnerParticipants;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
