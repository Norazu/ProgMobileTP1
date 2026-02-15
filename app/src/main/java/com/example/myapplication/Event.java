package com.example.myapplication;

public class Event {
    private String time;
    private String title;

    public Event(String time, String title) {
        this.time = time;
        this.title = title;
    }

    public String getTime() { return time; }
    public String getTitle() { return title; }
}