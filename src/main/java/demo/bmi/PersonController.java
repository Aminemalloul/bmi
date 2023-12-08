package demo.bmi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Mohammed Amine Malloul
 * Created 05/11/2023
 */


@RestController
@CrossOrigin(origins = "https://red-sky-08fa64a03.4.azurestaticapps.net")
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