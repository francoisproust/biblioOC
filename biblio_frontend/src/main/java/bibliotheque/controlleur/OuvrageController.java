package bibliotheque.controlleur;

import bibliotheque.modele.Ouvrage;
import bibliotheque.modele.ResultatExemplaire;
import bibliotheque.proxies.BibliothequeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OuvrageController {

    private final BibliothequeProxy bibliothequeProxy;

    @Autowired
    public OuvrageController(BibliothequeProxy bibliothequeProxy){
        this.bibliothequeProxy = bibliothequeProxy;
    }

    @GetMapping("/rechercher-ouvrage")
    public ModelAndView rechercherOuvrage(Model model){
        Ouvrage ouvrage = new Ouvrage();
        model.addAttribute("ouvrage",ouvrage);
        return new ModelAndView("rechercher-ouvrage");
    }
    @PostMapping("/rechercher-ouvrage")
    public ModelAndView rechercherOuvragePost(Model model, @ModelAttribute("ouvrage") Ouvrage ouvrage){
        List<ResultatExemplaire> resultatExemplaire = new ArrayList();
        resultatExemplaire = bibliothequeProxy.getResultatExemplaire(ouvrage);
        return new ModelAndView("liste-ouvrage","resultatExemplaire", resultatExemplaire);
    }

}
