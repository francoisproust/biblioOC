package com.bibliotheque.modele.entities;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

public class ReserverTest {
    @Test
    public void testGettersAndSetters(){
        Reserver reserver = new Reserver();
        Date dateAlerte = Date.valueOf(LocalDate.now());
        Date dateReservation = Date.valueOf(LocalDate.now());
        reserver.setReserverId(1);
        reserver.setDateAlerte(dateAlerte);
        reserver.setDateReservation(dateReservation);

        Assert.assertEquals(java.util.Optional.of(1).get(), reserver.getReserverId());
        Assert.assertEquals(dateAlerte,reserver.getDateAlerte());
        Assert.assertEquals(dateReservation,reserver.getDateReservation());
    }
}
