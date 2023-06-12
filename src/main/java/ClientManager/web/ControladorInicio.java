package ClientManager.web;

import ClientManager.domain.Person;
import ClientManager.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private PersonService personServ;

    @GetMapping("/")
    public String start(Model model) {
        var persons = personServ.listPersons();
        model.addAttribute("persons", persons);
        return "index";
    }

    @GetMapping("/addPerson")
    public String addPerson(Person person){
        return "modifyPerson";
    }

    @PostMapping("/savePerson")
    public String savePerson(Person person){
        personServ.savePerson(person);
        return "redirect:/";
    }
}
