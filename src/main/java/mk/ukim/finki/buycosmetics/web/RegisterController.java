package mk.ukim.finki.buycosmetics.web;


import mk.ukim.finki.buycosmetics.model.Role;
import mk.ukim.finki.buycosmetics.model.exceptions.InvalidArgumentException;
import mk.ukim.finki.buycosmetics.service.KorisnikService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final KorisnikService korisnikService;

    public RegisterController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String repeatedPassword,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam Role role) {
        try {
            this.korisnikService.register(username, password, repeatedPassword, name, surname, role);
            return "redirect:/login";
        } catch (InvalidArgumentException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }

}
