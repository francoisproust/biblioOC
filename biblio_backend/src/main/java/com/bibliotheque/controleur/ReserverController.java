package com.bibliotheque.controleur;

import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReserverController {

    @Autowired
    ReserverService reserverService;

    @GetMapping("/reserver/{usagerId}")
    public List<Reserver> ListerReservationUsager(@PathVariable Integer usagerId){
        List<Reserver> listeReservationUsager = reserverService.rechercherResa(usagerId);
        return listeReservationUsager;
    }
}
