package org.launchcode.codingevents.controllers;

import org.attoparser.trace.MarkupTraceEvent;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {
    @Autowired
    public EventRepository eventRepository;

    @GetMapping
    public String displayAllEvents(Model model) {
//        EventData.addEvent(new Event("Summer of Code","EXPLORING FUN TECHNOLOGY CONCEPTS IN OUR WEEK-LONG CODING CAMP."));
//        EventData.addEvent(new Event("Coding & Cocktails", "The Liquor – Intro to Javascript"));
//        EventData.addEvent(new Event("DevOps KC", "We're well into summer here in KC, and so we're working on a nice way to cool off and have some relaxing conversations about DevOps and Tech."));
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEventForms(Model model) {
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }
    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            model.addAttribute("errorMsg", "Check the errors above and try again.");
//            return "events/create";
//        }
        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title","Delete Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/delete-event";
    }
    @PostMapping("delete")
    public String deleteEventsForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int eventId : eventIds) {
                eventRepository.deleteById(eventId);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
//        Event currentEvent = eventRepository.findById(eventId);
//        model.addAttribute("currentEvent", currentEvent);
//        String title = "Edit Event "+ currentEvent.getName() + " ("+currentEvent.getId()+")";
//        model.addAttribute("title", title);
        return "events/edit";
    }
    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
//        Event currentEvent = eventRepository.findById(eventId);
//        currentEvent.setName(name);
//        currentEvent.setDescription(description);
        return "redirect:";

    }
}
