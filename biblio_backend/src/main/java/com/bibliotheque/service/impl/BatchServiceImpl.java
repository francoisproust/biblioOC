package com.bibliotheque.service.impl;

import com.bibliotheque.modele.dao.ReserverDao;
import com.bibliotheque.modele.entities.Reserver;
import com.bibliotheque.service.BatchService;
import com.bibliotheque.service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
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
        List<Integer> listeOuvrageId =  suppressionResaDepasses();
        List<Reserver> listeNouvellesResa = listeNouvellesResa(listeOuvrageId);
        envoiMail(listeNouvellesResa);
        ajoutDateAlerte(listeNouvellesResa);
    }

    /**
     * supprime les réservations dépassées et
     * retourne la liste d'ouvrage ayant une liste
     * @return
     */
    @Transactional
    public List<Integer> suppressionResaDepasses(){
        List<Integer> listeOuvrageId = new ArrayList<>();
        Date dateDuJour = java.sql.Date.valueOf(  LocalDate.now().plusDays(2));
        List<Reserver> reservation = reserverDao.findAllByDateAlerteAfter(dateDuJour);
        if(!reservation.isEmpty()){
            for(int i =0; i<reservation.size();i++){
                listeOuvrageId.add(reservation.get(i).getOuvrage().getOuvrageId());
                reserverService.annulerResa(reservation.get(i).getReserverId());
            }
        }
        return listeOuvrageId;
    }

    /**
     * a partir d'une liste d'ouvrage
     * retourne une liste de résa
     * @param listeOuvrageId
     * @return
     */
    private List<Reserver> listeNouvellesResa(List<Integer> listeOuvrageId){
        List<Reserver> listeNouvellesResa = new ArrayList<>();
        for(int i =0;i<listeOuvrageId.size();i++){
            List<Reserver> reserver = reserverDao.findAllByOuvrage_OuvrageIdOrderByReserverId(listeOuvrageId.get(i));
            listeNouvellesResa.add(reserver.get(0));
        }
        return listeNouvellesResa;
    }

    private void envoiMail(List<Reserver> reservers){
        for (int i = 0;i<reservers.size();i++){
            reserverService.sendMailToMember(reservers.get(i));
        }
    }

    @Transactional
    public void ajoutDateAlerte(List<Reserver> reservers){
        Date dateAlerte = new Date();
        for (int i = 0;i<reservers.size();i++){
            reservers.get(i).setDateAlerte(dateAlerte);
            reserverDao.save(reservers.get(i));
        }
    }
}
