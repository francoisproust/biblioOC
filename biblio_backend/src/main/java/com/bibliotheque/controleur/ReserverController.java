package com.bibliotheque.controleur;

import com.bibliotheque.mapping.CreerReservation;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.BatchService;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReserverController {

    @Autowired
    ReserverService reserverService;
    @Autowired
    BatchService batchService;

    //Liste les réservations d'un usager à partir de son id
    @GetMapping("/reserver/{usagerId}")
    public List<Reserver> listerReservationUsager(@PathVariable Integer usagerId){
        return reserverService.rechercherResa(usagerId);
    }

    //Annule une réservation à partir de son id
    @GetMapping("annuler-reservation/{reserverId}")
    public String annulerReservation(@PathVariable Integer reserverId){
        reserverService.annulerResa(reserverId);
        return "la réservation est annulée";
    }

    //reserver un ouvrage
    @PostMapping("/reserver")
    public Reserver creerReservation(@RequestBody CreerReservation creerReservation){
         return reserverService.creerResa(creerReservation);
    }

    @GetMapping("/reserver/refresh")
    public void refreshReservation(){
            batchService.refreshReservation();
    }
}
