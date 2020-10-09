package com.bibliotheque.modele.dao;

import com.bibliotheque.modele.entities.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserverDao extends JpaRepository<Reserver,Integer> {
    List<Reserver> findAllByUsager_UsagerId(Integer usagerId);
    void deleteByReserverId(Integer reserverId);
}
