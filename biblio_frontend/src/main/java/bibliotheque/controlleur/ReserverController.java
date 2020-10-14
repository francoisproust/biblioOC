package bibliotheque.controlleur;

import bibliotheque.modele.Reserver;
import bibliotheque.modele.Usager;
import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReserverController {
    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    public ReserverController(BibliothequeProxy bibliothequeProxy){
        this.bibliothequeProxy = bibliothequeProxy;
    }

    @GetMapping("/reserver/{ouvrageId}")
    public ModelAndView creerReservation(Model model, @PathVariable Integer ouvrageId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return new ModelAndView("redirect:/");
        }
        Reserver reserver = new Reserver();
        reserver.setUsagerId(ouvrageId);
        Usager usager = (Usager) auth.getPrincipal();
        reserver.setUsagerId(usager.getUsagerId());
        bibliothequeProxy.creerReservation(reserver);
        return new ModelAndView("redirect/mon-profil");
    }
}
