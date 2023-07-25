package org.launchcode.codingevents.controllers;

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
    private static HashMap<String, String> events = new HashMap<>();
    @GetMapping
    public String displayAllEvents(Model model) {
        events.put("Summer of Code", "EXPLORING FUN TECHNOLOGY CONCEPTS IN OUR WEEK-LONG CODING CAMP.");
        events.put("Coding & Cocktails","The Liquor – Intro to Javascript");
        events.put("DevOps KC","We're well into summer here in KC, and so we're working on a nice way to cool off and have some relaxing conversations about DevOps and Tech.");
        model.addAttribute("events", events);
        return "events/index";
    }
    @GetMapping("create")
    public String renderCreateEventForms() {
        return "events/create";
    }
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName) {
        events.put(eventName, "No Description");
        return "redirect:";
    }
}
