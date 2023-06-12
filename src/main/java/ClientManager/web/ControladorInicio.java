package ClientManager.web;

import ClientManager.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonService personServ;

    @GetMapping("/")
    public String start(Model model) {
        var message = "Hola mundo con Spring";
        var persons = personServ.listPersons();
        model.addAttribute("message", message);
        model.addAttribute("persons", persons);

        return "index";
    }
}
