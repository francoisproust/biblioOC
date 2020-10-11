package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.BatchService;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    ReserverDao reserverDao;
    @Autowired
    ReserverService reserverService;

    @Override
    public void refreshReservation() {
        List<Reserver> reservation = reserverDao.findAll();
        suppressionResaDepasses(reservation);
        envoiMail(reservation);
        ajoutDateAlerte(reservation);
    }

    private void suppressionResaDepasses(List<Reserver> reservers){
        Date dateDuJour = new Date();
        for(int i=0;i<reservers.size();i++){
            Date dateAlerte = reservers.get(i).getDateAlerte();
            if(dateAlerte.compareTo(dateDuJour) > 2){
                reserverDao.deleteByReserverId(reservers.get(i).getReserverId());
            }
        }
    }

    private void envoiMail(List<Reserver> reservers){
        for (int i = 0;i<reservers.size();i++){
            reserverService.sendMailToMember(reservers.get(i));
        }
    }

    private void ajoutDateAlerte(List<Reserver> reservers){
        Date dateAlerte = new Date();
        for (int i = 0;i<reservers.size();i++){
            reservers.get(i).setDateAlerte(dateAlerte);
        }
    }
}
