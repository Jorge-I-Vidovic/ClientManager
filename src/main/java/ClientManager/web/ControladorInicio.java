package ClientManager.web;

import ClientManager.dao.PersonDAO;
import ClientManager.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonDAO pd;
    @GetMapping("/")
    public String start(Model model) {
        var message = "Hola mundo con Spring";
        var persons = pd.findAll();
        model.addAttribute("message", message);
        model.addAttribute("persons",persons);

        return "index";
    }
}
