package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.entities.*;
import com.bibliotheque.service.ExemplaireService;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {
    @Autowired
    ExemplaireDao exemplaireDao;
    @Autowired
    ReserverDao reserverDao;
    @Autowired
    ReserverService reserverService;

    @Override
    public Exemplaire prolongerEmprunt(Integer exemplaireId) {
        Exemplaire exemplaire = chercherExemplaireParId(exemplaireId);
        exemplaire = modificationDateEtProlongation(exemplaire);
        exemplaire.setProlongation(true);
        exemplaireDao.save(exemplaire);
        return exemplaire;
    }

    @Override
    public List<Exemplaire> mesEmprunts(Integer usagerId) {
        List<Exemplaire> exemplaires = exemplaireDao.findAllByUsager_UsagerId(usagerId);
        return exemplaires;
    }

    @Override
    public List<Exemplaire> listerEmprunts() {
        List<Exemplaire> exemplaires = exemplaireDao.findAllByDisponibleFalse();
        return exemplaires;
    }

    @Override
    public void rendreEmprunt(Integer exemplaireId) {
        Exemplaire exemplaire = chercherExemplaireParId(exemplaireId);
        chercherResaPourAlerte(exemplaire.getOuvrage());
        exemplaire.setDisponible(true);
        exemplaire.setProlongation(false);
        exemplaire.setUsager(null);
        exemplaire.setDateDebut(null);
        exemplaire.setDateFin(null);
        exemplaireDao.save(exemplaire);
    }

    @Override
    public String emprunterExemplaire(Exemplaire exemplaire) {
        Exemplaire exemplaireEmprunte = exemplaireDao.findByExemplaireId(exemplaire.getExemplaireId());
        chercherResaPourSuppression(exemplaire.getUsager(),exemplaire.getOuvrage());
        exemplaireEmprunte.setUsager(exemplaire.getUsager());
        exemplaireEmprunte.setDisponible(false);
        exemplaireEmprunte.setProlongation(false);
        exemplaireEmprunte =modificationDateEtProlongation(exemplaireEmprunte);
        exemplaireDao.save(exemplaireEmprunte);
        return String.valueOf(exemplaireEmprunte.getDateFin());
    }

    @Override
    public List<String> listerEmail() {
        List<String> email = new ArrayList<>();
        List<Exemplaire> exemplaires = exemplaireDao.findAllByDateFinBefore(Date.valueOf(LocalDate.now()));
        for (int i = 0; i<exemplaires.size();i++){
            String adresse = exemplaires.get(i).getUsager().getEmail();
            email.add(adresse);
        }
        return email;
    }


    private Exemplaire chercherExemplaireParId(Integer exemplaireId){
        Optional<Exemplaire> exemplaire = exemplaireDao.findById(exemplaireId);
        return exemplaire.isPresent() ? exemplaire.get() :null ;
    }


    private Exemplaire modificationDateEtProlongation(Exemplaire exemplaire){
        // gestion date de début
        if(exemplaire.getDateDebut() == null){
            exemplaire.setDateDebut(Date.valueOf(LocalDate.now()));
        }
        // gestion date de fin
        if(exemplaire.getDateFin() == null){
            exemplaire.setDateFin(Date.valueOf(  LocalDate.now().plusDays(28)));
        }else{
            exemplaire.setDateFin(Date.valueOf(exemplaire.getDateFin().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(28)));
        }
        return exemplaire;
    }

    /**
     * methode qui permet de récupérer la liste des réservations pour un ouvrage
     * et si l'usager est le premier on supprime sa réservation en créant un emprunt
     * @param usager
     * @param ouvrage
     */
    private void chercherResaPourSuppression(Usager usager, Ouvrage ouvrage){
        List<Reserver> liste = reserverDao.findAllByOuvrage_OuvrageIdorOrderByReserverId(ouvrage.getOuvrageId());
        if(liste.get(0).getUsager().getUsagerId().equals(usager.getUsagerId())){
            reserverDao.deleteByReserverId(liste.get(0).getReserverId());
        }
    }

    /**
     * methode qui permet a partir d'un ouvrage de sélectionner le premier de la liste pour
     * envoi d'un mail
     * @param ouvrage
     */
    private void chercherResaPourAlerte(Ouvrage ouvrage){
        List<Reserver> liste = reserverDao.findAllByOuvrage_OuvrageId(ouvrage.getOuvrageId());
        Reserver reservation = liste.get(0);
        reserverService.sendMailToMember(reservation);
        reservation.setDateAlerte(new java.util.Date());
        reserverDao.save(reservation);
    }
}
