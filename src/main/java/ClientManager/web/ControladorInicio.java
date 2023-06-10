package ClientManager.web;

import ClientManager.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@Slf4j
public class ControladorInicio {
    @GetMapping("/")
    public String start(Model model) {
        var message = "Hola mundo con Spring";
        model.addAttribute("message", message);

        return "index";
    }
}
