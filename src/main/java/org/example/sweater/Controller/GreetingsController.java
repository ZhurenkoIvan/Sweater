package org.example.sweater.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingsController {

    @GetMapping("/greetings")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "FUCKERS") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


}
