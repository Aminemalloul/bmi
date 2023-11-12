package demo.bmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Author: Mohammed Amine Malloul
 * Created 05/11/2023
 */


@Controller
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("newPerson", new Person());
        return "index";
    }

    @PostMapping("/add-person")
    public String addPerson(@ModelAttribute Person newPerson) {
        personRepository.save(newPerson);
        return "redirect:/";
    }
}