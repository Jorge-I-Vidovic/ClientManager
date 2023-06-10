package ClientManager;

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

        var person = new Person();
        person.setName("Jorge I.");
        person.setSurname("Vidovic");
        person.setEmail("mail@email.com");
        person.setPhoneNumber("123456789");

        var person2 = new Person();
        person2.setName("Anna G.");
        person2.setSurname("Rodrigues");
        person2.setEmail("mail@email.com");
        person2.setPhoneNumber("987654321");

        var persons = new ArrayList();
        persons.add(person);
        persons.add(person2);

        model.addAttribute("message", message);
        model.addAttribute("persons", persons);
        return "index";
    }
}
