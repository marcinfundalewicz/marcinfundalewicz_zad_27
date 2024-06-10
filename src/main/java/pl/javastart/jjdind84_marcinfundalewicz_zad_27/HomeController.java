package pl.javastart.jjdind84_marcinfundalewicz_zad_27;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private PersonRepository personRepository;

    public HomeController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    String home(Model model) {
        model.addAttribute("people", personRepository.findAll());
        return "index";
    }

    @GetMapping("/addNewPerson")
    String addNewPerson(Model model) {
        model.addAttribute("person", new Person());
        return "addNewPersonForm";
    }

    @PostMapping("/addNewPerson")
    String addNewPerson(Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
}
