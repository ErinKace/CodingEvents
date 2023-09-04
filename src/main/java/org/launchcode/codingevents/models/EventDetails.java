package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class EventDetails extends AbstractEntity {
    @Size(max=500, message="Only 500 characters allowed")
    private String description;
    @NotBlank
    @Email(message="Must be a valid email")
    private String contactEmail;
    @NotBlank(message="Please provide a location")
    @NotNull
    private String location;
    @Min(1)
    private Integer numAttendees;
    @Future(message="Event must be a future date")
    private LocalDate eventDate;
    public EventDetails() {
    }
    public EventDetails(String description, String contactEmail, String location, Integer numAttendees, LocalDate eventDate) {
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.numAttendees = numAttendees;
        this.eventDate = eventDate;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return description+" \n"
                +location+" \n"
                +contactEmail;
    }
}
