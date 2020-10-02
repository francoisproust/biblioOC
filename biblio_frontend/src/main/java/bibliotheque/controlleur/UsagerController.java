package bibliotheque.controlleur;

import bibliotheque.modele.Usager;
import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UsagerController {
    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsagerController(BibliothequeProxy bibliothequeProxy){
        this.bibliothequeProxy = bibliothequeProxy;
    }

    @GetMapping(value = "/creation-compte")
    public ModelAndView creationCompte(Model model) {
        model.addAttribute("usager", new Usager());
        return new ModelAndView("creation-compte");
    }

    @PostMapping(value = "/creation-compte")
    public ModelAndView creationComptePost(Model model, @ModelAttribute("usager") Usager usager) {
        usager.setPassword(passwordEncoder.encode(usager.getPassword()));
        bibliothequeProxy.creationCompte(usager);
        return new ModelAndView("home" );
    }

    @GetMapping("/login")
    public ModelAndView login (Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/");
        }
        model.addAttribute("usager",new Usager());
        return new ModelAndView("login");
    }

    @PostMapping(value = "/login")
    public ModelAndView loginPost(Model model, @ModelAttribute("usager") Usager usager){
        bibliothequeProxy.chercherUsagerParIdentifiant(usager.getIdentifiant());
        return new ModelAndView("home");
    }
/**
    @GetMapping("/mon-profil")
    public ModelAndView monprofil(Model model){
        Authentication usager = SecurityContextHolder.getContext().getAuthentication();
        List<Exemplaire> exemplaires = bibliothequeProxy.listerMesEmprunts(1);
        model.addAttribute(exemplaires);
    }
    **/
}
