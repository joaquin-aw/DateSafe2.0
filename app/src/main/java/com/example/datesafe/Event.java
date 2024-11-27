package com.example.datesafe;

public class Event {
    private String name;
    private String date;
    private String description;
    private boolean isSignedUp;

    public Event(String name, String date, String description) {
        this.name = name;
        this.date = date;
        this.description = description;
        this.isSignedUp = false; // Default state
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSignedUp() {
        return isSignedUp;
    }

    public void setSignedUp(boolean signedUp) {
        isSignedUp = signedUp;
    }
}

