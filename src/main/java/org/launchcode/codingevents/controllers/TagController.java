package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.TagRepository;
import org.launchcode.codingevents.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("tags")
public class TagController {
    @Autowired
    private TagRepository tagRepository;
    @GetMapping()
    public String displayTags(Model model) {
        model.addAttribute("title", "All Tags");
        model.addAttribute("tags", tagRepository.findAll());
        return "tags/index.html";
    }
    @GetMapping("create")
    public String displayCreateTagForm(Model model) {
        model.addAttribute("title", "Create New Tag");
        model.addAttribute(new Tag());
        return "tags/create.html";
    }
    @PostMapping("create")
    public String processCreateTagForm(@ModelAttribute @Valid Tag tag, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create New Tag");
            return "tags/create.html";
        }
        model.addAttribute("title", "Tags");
        tagRepository.save(tag);
        return "redirect:";
    }
}
