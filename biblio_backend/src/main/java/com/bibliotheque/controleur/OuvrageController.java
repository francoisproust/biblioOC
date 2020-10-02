package com.bibliotheque.controleur;

import com.bibliotheque.mapping.ResultOuvrage;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.service.OuvrageCustomService;
import com.bibliotheque.service.OuvrageService;
import com.bibliotheque.service.impl.OuvrageFromCriterias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OuvrageController {
    @Autowired
    OuvrageService ouvrageService;

    @Autowired
    OuvrageCustomService ouvrageCustomService;

    @GetMapping("/ouvrage")
    public List<Ouvrage> listerOuvrage(){
        List<Ouvrage> ouvrages = ouvrageService.listerOuvrage();
        return ouvrages;
    }

    @PostMapping("/rechercher-ouvrage")
    public List<ResultOuvrage> rechercherOuvrage(@RequestBody OuvrageFromCriterias ouvrageFromCriterias){
        List<Ouvrage> ouvrages = ouvrageCustomService.multiCriteriaOuvrage(ouvrageFromCriterias);
        List<ResultOuvrage> resultOuvrages = new ArrayList<>();
        for(Ouvrage ouv:ouvrages){
            ResultOuvrage resultOuvrage = new ResultOuvrage();
            resultOuvrage.setNom(ouv.getNom());
            resultOuvrage.setNombreDispo(ouv.getExemplaires().stream().filter((Exemplaire::getDisponible)).count());
            resultOuvrages.add(resultOuvrage);
        }
        return resultOuvrages;
    }

    @GetMapping("/emprunt-retarder")
    public List<Exemplaire> empruntEnRetard(){
        List<Exemplaire> exemplaires = ouvrageService.listerEmpruntEnRetard();
        return exemplaires;
    }

}
