package de.sadrab.Mp15PiratesoftheCodeBean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private Logic logic;

    public HomeController(Logic logic) {
        this.logic = logic;
    }

    @ModelAttribute("result")
    Result result() {
        return logic.getResult();
    }

    @GetMapping
    String page() {
        return "home";
    }
    @PostMapping("/choose/{number}")
    String choose(@PathVariable Integer number){
        logic.next(number);
        return "redirect:/";
    }
}
