package com.bibliotheque.controleur;

import com.bibliotheque.mapping.CreerReservation;
import com.bibliotheque.mapping.MesReservations;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.BatchService;
import com.bibliotheque.service.OuvrageService;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReserverController {

    @Autowired
    ReserverService reserverService;
    @Autowired
    BatchService batchService;
    @Autowired
    OuvrageService ouvrageService;

    //Liste les réservations d'un usager à partir de son id
    @GetMapping("/reserver/{usagerId}")
    public List<MesReservations> listerReservationUsager(@PathVariable Integer usagerId){
        List<MesReservations> mesReservations = new ArrayList<>();
        List<Reserver> reservers = reserverService.rechercherResa(usagerId);
        if(!reservers.isEmpty()){
            for (int i=0;i<reservers.size();i++){
                MesReservations uneResa = new MesReservations();
                uneResa.setReservationId(reservers.get(i).getReserverId());
                uneResa.setOuvrageId(reservers.get(i).getOuvrage().getOuvrageId());
                uneResa.setNomOuvrage(reservers.get(i).getOuvrage().getNom());
                uneResa.setDateDeRetour(ouvrageService.dateRetourPrevue(reservers.get(i).getOuvrage().getOuvrageId()));
                uneResa.setRang(ouvrageService.chercherRang(reservers.get(i).getOuvrage().getOuvrageId(),usagerId));
                mesReservations.add(uneResa);
            }
        }
        return mesReservations;
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
