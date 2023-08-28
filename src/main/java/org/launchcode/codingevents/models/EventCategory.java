package org.launchcode.codingevents.models;

import org.launchcode.codingevents.controllers.EventController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class EventCategory {
    @Id
    @GeneratedValue
    private int id;
    @Size(min=3,message="The name must be at least 3 characters long")
    private String name;

    public EventCategory(@Size(min=3,message="The name must be at least 3 characters long") String aName) {
        this.name = aName;
    }
    public EventCategory() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventCategory)) return false;
        EventCategory that = (EventCategory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
