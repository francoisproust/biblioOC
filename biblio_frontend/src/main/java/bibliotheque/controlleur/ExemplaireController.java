package bibliotheque.controlleur;

import bibliotheque.modele.Exemplaire;
import bibliotheque.modele.Usager;
import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ExemplaireController {
    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    public ExemplaireController(BibliothequeProxy bibliothequeProxy){
        this.bibliothequeProxy = bibliothequeProxy;
    }


    @GetMapping("/prolonger/{exemplaireId}")
    public String monProfil(Model model, @PathVariable Integer exemplaireId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Usager usager = (Usager) auth.getPrincipal();
        bibliothequeProxy.prolongerEmprunt(exemplaireId);
        List<Exemplaire> exemplaires = bibliothequeProxy.consulterMesEmprunts(usager.getUsagerId());
        model.addAttribute("usager", usager);
        model.addAttribute("exemplaires", exemplaires);
        return "redirect:/mon-profil";
    }
}
