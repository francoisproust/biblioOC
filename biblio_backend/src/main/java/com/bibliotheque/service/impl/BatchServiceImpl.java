package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BatchServiceImpl implements BatchService {
    @Autowired
    ReserverDao reserverDao;

    @Override
    public void refreshReservation() {
        Date dateDuJour = new Date();
        List<Reserver> reservation = reserverDao.findAll();
        for(int i=0;i<reservation.size();i++){
            Date dateAlerte = reservation.get(i).getDateAlerte();
            if(dateAlerte.compareTo(dateDuJour) > 2){
                reserverDao.deleteByReserverId(reservation.get(i).getReserverId());
            }
        }
    }
}
