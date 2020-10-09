package com.bibliotheque.service.impl;

import com.bibliotheque.mapping.CreerReservation;
import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.dao.OuvrageDao;
import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.dao.UsagerDao;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.modele.entities.Usager;
import com.bibliotheque.service.OuvrageService;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReserverServiceImpl implements ReserverService {

    @Autowired
    ReserverDao reserverDao;
    @Autowired
    OuvrageDao ouvrageDao;
    @Autowired
    UsagerDao usagerDao;
    @Autowired
    ExemplaireDao exemplaireDao;
    @Autowired
    OuvrageService ouvrageService;

    @Override
    public List<Reserver> rechercherResa(Integer usagerId) {
        List<Reserver> list = reserverDao.findAllByUsager_UsagerId(usagerId);
        return list;
    }

    @Override
    public void annulerResa(Integer reserverId) {
        reserverDao.deleteByReserverId(reserverId);
    }

    @Override
    public Reserver creerResa(CreerReservation creerReservation) {
        Reserver reserver = new Reserver();
        boolean reservation = reservationPossible(creerReservation);
        if(reservation){
            Ouvrage ouvrage = chercherOuvrage(creerReservation.getOuvrageId());
            Usager usager = chercherUsager(creerReservation.getUsagerId());
            reserver.setOuvrage(ouvrage);
            reserver.setUsager(usager);
            reserver.setDateReservation(new Date());
            reserverDao.save(reserver);
        }
        return reserver;
    }


    /**
     * vérification qu'un usager peut réserver un ouvrage
     * @param creerReservation
     * @return
     */
    private Boolean reservationPossible(CreerReservation creerReservation){
        boolean possible = false;
        boolean resaOuvragePossible = reservationPossibleOuvrage(creerReservation);
        boolean exemplaireNonEnCours = verifierPasEmprunter(creerReservation);
        if (exemplaireNonEnCours && resaOuvragePossible ){
            possible = true;
        }
        return possible;
    }

    /**
     * Calcul si on peut reserver un ouvrage
     * @param creerReservation
     * @return
     */
    private Boolean reservationPossibleOuvrage(CreerReservation creerReservation){
        boolean reservationPossible = false;
        int nbResaPossible = ouvrageService.nbResaAutorise(creerReservation.getOuvrageId());
        int nombreResaEnCours = reserverDao.findAllByOuvrage_OuvrageId(creerReservation.getOuvrageId()).size();
        if(nombreResaEnCours < nbResaPossible){
            reservationPossible = true;
        }
        return  reservationPossible;
    }

    /**
     * vérifie que l'usager n'as pas déjà un exemplaire emprunté de l ouvrage
     * @param creerReservation
     * @return
     */
    private Boolean verifierPasEmprunter(CreerReservation creerReservation){
        boolean reservationPossible = true;
        Usager usager = chercherUsager(creerReservation.getUsagerId());
        List<Exemplaire> exemplaires = exemplaireDao.findAllByUsager(usager);
        for(int i=0; i<exemplaires.size(); i++){
            if(exemplaires.get(i).getUsager().getUsagerId().equals(creerReservation.getUsagerId())){
                reservationPossible = false;
                break;
            }
        }
        return reservationPossible;
    }

    private Ouvrage chercherOuvrage(Integer ouvrageId){
        Optional<Ouvrage> ouvrage = ouvrageDao.findById(ouvrageId);
        return ouvrage.isPresent() ? ouvrage.get() :null ;
    }

    private Usager chercherUsager(Integer usagerId){
        Optional<Usager> usager = usagerDao.findById(usagerId);
        return usager.isPresent() ? usager.get() :null ;
    }
}
