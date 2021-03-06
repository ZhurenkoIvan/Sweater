package org.example.sweater.controllers;

import org.example.sweater.domain.Message;
import org.example.sweater.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    MessageRepository messageRepository;


    @GetMapping("/")
    public String greeting(Map<String, Object> model)
    {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag , Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";

    }

    @PostMapping("filter")
    public String filter(@RequestParam String tag, Map<String, Object> model){
        Iterable<Message> messages;
        if (tag != null && !tag.isEmpty()) {
            messages = messageRepository.findByTag(tag);
        } else {
            messages = messageRepository.findAll();
        }
        model.put("messages", messages);

        return "main";
    }


}
