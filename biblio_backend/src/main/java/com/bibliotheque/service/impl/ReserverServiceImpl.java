package com.bibliotheque.service.impl;

import com.bibliotheque.mapping.CreerReservation;
import com.bibliotheque.modele.dao.OuvrageDao;
import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.dao.UsagerDao;
import com.bibliotheque.modele.entities.Ouvrage;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.modele.entities.Usager;
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
        Ouvrage ouvrage = chercherOuvrage(creerReservation.getOuvrageId());
        Usager usager = chercherUsager(creerReservation.getUsagerId());
        reserver.setOuvrage(ouvrage);
        reserver.setUsager(usager);
        reserver.setDateReservation(new Date());
        reserverDao.save(reserver);
        return reserver;
    }

    private Usager chercherUsager(Integer usagerId){
        Optional<Usager> usager = usagerDao.findById(usagerId);
        return usager.isPresent() ? usager.get() :null ;
    }

    private Ouvrage chercherOuvrage(Integer ouvrageId){
        Optional<Ouvrage> ouvrage = ouvrageDao.findById(ouvrageId);
        return ouvrage.isPresent() ? ouvrage.get() :null ;
    }
}
