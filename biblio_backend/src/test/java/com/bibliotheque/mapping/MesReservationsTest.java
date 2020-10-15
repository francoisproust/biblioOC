package com.bibliotheque.mapping;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

public class MesReservationsTest {
    @Test
    public void testGettersAndSetters(){
        MesReservations mesReservations = new MesReservations();
        Date dateDeRetour = Date.valueOf(LocalDate.now());
        mesReservations.setRang(1);
        mesReservations.setNomOuvrage("mon ouvrage");
        mesReservations.setOuvrageId(3);
        mesReservations.setDateDeRetour(dateDeRetour);

        Assert.assertEquals(dateDeRetour,mesReservations.getDateDeRetour());
        Assert.assertEquals(java.util.Optional.of(1).get(),mesReservations.getRang());
        Assert.assertEquals("mon ouvrage",mesReservations.getNomOuvrage());
        Assert.assertEquals(java.util.Optional.of(3).get(),mesReservations.getOuvrageId());
    }
}
