package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReserverDao extends JpaRepository<Reserver,Integer> {
    List<Reserver> findAllByUsager_UsagerId(Integer usagerId);
    void deleteByReserverId(Integer reserverId);
    List<Reserver> findAllByOuvrage_OuvrageId(Integer ouvrageId);
    List<Reserver> findAllByOuvrage_OuvrageIdOrderByReserverId(Integer ouvrageId);
    List<Reserver> findAllByDateAlerteAfter(Date date);
    List<Reserver> findAllByDateAlerteBefore(Date date);
}
