package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

public class Event {
    @NotBlank
    @Size(min=3,max=50, message="Name must be between 3 and 50 characters")
    private String name;
    @Size(max=500, message="Only 500 characters allowed")
    private String description;
    @NotBlank
    @Email(message="Must be a valid email")
    private String contactEmail;
    @NotBlank(message="Please provide a location")
    @NotNull
    private String location;
//    @AssertTrue(message="You have to check yes. Idk why we even asked.")
//    private Boolean mustRegister;
    @Min(1)
    private Integer numAttendees;
    @Future(message="Event must be a future date")
    private LocalDate eventDate;
    private EventType type;
    private int id;
    private static int nextId=1;

    public Event(String name, String description, String contactEmail, String location, Boolean mustRegister, Integer numAttendees, LocalDate eventDate, EventType eventType) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
//        this.mustRegister = mustRegister;
        this.numAttendees = numAttendees;
        this.eventDate = eventDate;
        this.type = eventType;
    }
    public Event() {
        this.id = nextId;
        this.nextId++;
    }
//    public Event(String name, String description) {
//        this(name);
//        this.description = description;
//    }

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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

//    public Boolean getMustRegister() {
//        return mustRegister;
//    }
//
//    public void setMustRegister(Boolean mustRegister) {
//        this.mustRegister = mustRegister;
//    }

    public Integer getNumAttendees() {
        return numAttendees;
    }

    public void setNumAttendees(Integer numAttendees) {
        this.numAttendees = numAttendees;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
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
