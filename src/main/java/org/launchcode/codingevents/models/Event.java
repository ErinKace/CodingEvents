package org.launchcode.codingevents.models;

import java.util.Objects;

public class Event {
    private String name;
    private String description;
    private int id;
    private static int nextId=1;

    public Event(String name) {
        this.id = nextId;
        this.nextId++;
        this.name = name;
    }
    public Event(String name, String description) {
        this(name);
        this.description = description;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    //    "EXPLORING FUN TECHNOLOGY CONCEPTS IN OUR WEEK-LONG CODING CAMP."
//The Liquor – Intro to Javascript"
//    "We're well into summer here in KC, and so we're working on a nice way to cool off and have some relaxing conversations about DevOps and Tech."
}
