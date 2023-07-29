package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String createEvent(@RequestParam String eventName, @RequestParam String description) {
        EventData.addEvent(new Event(eventName, description));
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
}
