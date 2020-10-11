package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExemplaireController {
    @Autowired
    ExemplaireService exemplaireService;
    @Autowired
    UsagerService usagerService;

    @GetMapping("/prolonger/{exemplaireId}")
    public Exemplaire prolongerEmprunt(@PathVariable Integer exemplaireId){
        Exemplaire exemplaire = exemplaireService.prolongerEmprunt(exemplaireId);
        return exemplaire;
    }

    @GetMapping("/consulter-emprunts/{usagerId}")
    public List<Exemplaire> consulterMesEmprunts(@PathVariable Integer usagerId){
        List<Exemplaire> emprunts = exemplaireService.mesEmprunts(usagerId);
        return emprunts;
    }

    @GetMapping("/consulter-emprunts")
    public List<Exemplaire> consulterEmprunts(){
        List<Exemplaire> emprunts = exemplaireService.listerEmprunts();
        return emprunts;
    }

    @GetMapping("/rendre-emprunt/{exemplaireId}")
    public String rendreEmprunt(@PathVariable Integer exemplaireId){
        exemplaireService.rendreEmprunt(exemplaireId);
        return "l'exemplaire est rendu";
    }

    @PostMapping("/emprunter/{usagerId}")
    public String emprunterExemplaire(@RequestBody Exemplaire exemplaire, @PathVariable Integer usagerId){
        exemplaire.setUsager(usagerService.chercherParUsagerId(usagerId));
        String retour = "La date de retour de l'exemplaire est le : " + exemplaireService.emprunterExemplaire(exemplaire);
        return retour;
    }

    @GetMapping("/lister-retard")
    public List<String> listeMail(){
        List<String> email = exemplaireService.listerEmail();
        return email;
    }
}
