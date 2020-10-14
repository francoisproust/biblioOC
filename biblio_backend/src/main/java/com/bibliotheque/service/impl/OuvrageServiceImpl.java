package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ExemplaireDao;
import com.bibliotheque.modele.dao.OuvrageDao;
import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.entities.Exemplaire;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {
    @Autowired
    OuvrageDao ouvrageDao;
    @Autowired
    ReserverDao reserverDao;
    @Autowired
    ExemplaireDao exemplaireDao;
    @Override
    public List<Ouvrage> listerOuvrage() {
        List<Ouvrage> ouvrages = ouvrageDao.findAll();
        return ouvrages;
    }

    @Override
    public Integer chercherOuvragresDispo(Integer ouvrageId) {
        Integer nbDispo = exemplaireDao.findAllByOuvrage_OuvrageIdAndAndDisponibleTrue(ouvrageId).size();
        return nbDispo;
    }

    @Override
    public List<Exemplaire> listerEmpruntEnRetard() {
        Date date = new Date();
        List<Exemplaire> exemplaires = exemplaireDao.findAllByDateFinBefore(date);
        return exemplaires;
    }

    @Override
    public Integer nbResaAutorise(Integer ouvrageId) {
        return ouvrageDao.findAllByOuvrageId(ouvrageId).getExemplaires().size() * 2;
    }

    @Override
    public Date dateRetourPrevue(Integer ouvrageId) {
        List<Exemplaire> exemplaires = exemplaireDao.findAllByOuvrage_OuvrageIdOrderByDateFin(ouvrageId);
        Date dateDeFin = null;
        if(!exemplaires.isEmpty()){
            dateDeFin = exemplaires.get(0).getDateFin();
        }
        return dateDeFin;
    }

    @Override
    public Integer chercherRang(Integer ouvrageId, Integer usagerId) {
        List<Reserver> reservers = reserverDao.findAllByOuvrage_OuvrageIdOrderByReserverId(ouvrageId);
        Integer rang = 1;
        for (int i = 0; i<reservers.size();i++){
            if(reservers.get(i).getUsager().getUsagerId() != usagerId){
                rang = rang + 1;
            }
            break;
        }
        return rang;
    }
}
