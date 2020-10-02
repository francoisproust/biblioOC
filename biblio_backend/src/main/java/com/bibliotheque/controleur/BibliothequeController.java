package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Bibliotheque;
import com.bibliotheque.service.BibliothequeService;
import com.bibliotheque.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliothequeController {
    @Autowired
    BibliothequeService bibliothequeService;

    @Autowired
    OuvrageService ouvrageService;

    @GetMapping("/bibliotheque")
    public List<Bibliotheque> listerExemplaires(){
        List<Bibliotheque> listerBiblio = bibliothequeService.listerBiblio();
        return listerBiblio;
    }
}
