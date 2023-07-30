package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
//        EventData.addEvent(new Event("Summer of Code","EXPLORING FUN TECHNOLOGY CONCEPTS IN OUR WEEK-LONG CODING CAMP."));
//        EventData.addEvent(new Event("Coding & Cocktails", "The Liquor – Intro to Javascript"));
//        EventData.addEvent(new Event("DevOps KC", "We're well into summer here in KC, and so we're working on a nice way to cool off and have some relaxing conversations about DevOps and Tech."));
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEventForms() {
        return "events/create";
    }
    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent) {
        EventData.addEvent(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete-event";
    }
    @PostMapping("delete")
    public String deleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int eventId : eventIds) {
                EventData.removeEvent(eventId);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Event currentEvent = EventData.getById(eventId);
        model.addAttribute("currentEvent", currentEvent);
        String title = "Edit Event "+ currentEvent.getName() + " ("+currentEvent.getId()+")";
        model.addAttribute("title", title);
        return "events/edit";
    }
    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        Event editedEvent = EventData.getById(eventId);
        editedEvent.setName(name);
        editedEvent.setDescription(description);
        return "redirect:";

    }
}
