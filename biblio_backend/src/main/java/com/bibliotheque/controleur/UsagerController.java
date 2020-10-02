package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.TypeUser;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.TypeUserService;
import com.bibliotheque.service.UsagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsagerController {
    @Autowired
    UsagerService usagerService;
    @Autowired
    TypeUserService typeUserService;

    @PostMapping("/login")
    public boolean verifierConnexion(@PathVariable Usager usager){
        Boolean loginRetour = usagerService.verifierUsager(usager);
        return loginRetour;
    }

    @PostMapping("/creation-compte")
    public void creationCompte(@RequestBody Usager usager){
        usager.setTypeUser(typeUserService.chercherUserLecteur());
        usagerService.ajouterUsager(usager);
    }

    @GetMapping("/lister-usager")
    public List<Usager> listerUsager(){
        List<Usager> listeUsager = usagerService.listerUsager();
        return listeUsager;
    }

    @GetMapping("/chercher-usager/{identifiant}")
    public Usager chercherUsager(@PathVariable String identifiant){
        Usager usager = usagerService.chercherUsagerParIdentifiant(identifiant);
        return usager;
    }
}
