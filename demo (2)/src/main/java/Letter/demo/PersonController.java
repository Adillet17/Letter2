package Letter.demo;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/yurtahome")
public class PersonController {

    private final PersonService personService;
    private final PersonValidator personValidator;

    public PersonController(PersonService personService, PersonValidator personValidator) {
        this.personService = personService;
        this.personValidator = personValidator;
    }

    @GetMapping("/letter")
    public String letterPerson(@ModelAttribute("person") PersonModel person) {
        return "yurtahome/letter";
    }

    @PostMapping()
    public String createLetter(@RequestParam("photo") String photo,
                               @RequestParam ("review") String review,
                               @RequestParam ("letter")String letter,
                                           @RequestParam("know_how") String know_how,
                               @ModelAttribute("person") @Valid PersonModel person,
                               BindingResult bindingResult, Model model) {

        personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "yurtahome/letter";

        if (photo != null && !photo.isEmpty())
            person.setPhoto(photo);
        else if (review!=null&& !review.isEmpty())
            person.setReview(review);
        else if (letter!=null&& !letter.isEmpty())
            person.setLetter(letter);
        else if (know_how!=null && !know_how.isEmpty())
            person.setKnow_how(know_how);


        personService.save(person);

        return "redirect:/yurtahome/#soob";
    }
}
