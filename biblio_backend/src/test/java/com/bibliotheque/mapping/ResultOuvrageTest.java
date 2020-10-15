package com.bibliotheque.mapping;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

public class ResultOuvrageTest {
    @Test
    public void testGettersAndSetters(){
        ResultOuvrage resultOuvrage = new ResultOuvrage();
        Date dateRetourPrevue = Date.valueOf(LocalDate.now());
        resultOuvrage.setOuvrageId(1);
        resultOuvrage.setNombreResaPossibles(4);
        resultOuvrage.setNom("mon ouvrage");
        resultOuvrage.setNombreResaFaites(3);
        resultOuvrage.setDateDeRetourPrevu(dateRetourPrevue);
        resultOuvrage.setNombreDispo(4);

        Assert.assertEquals(java.util.Optional.of(1).get(),resultOuvrage.getOuvrageId());
        Assert.assertEquals(java.util.Optional.of(4).get(),resultOuvrage.getNombreResaPossibles());
        Assert.assertEquals("mon ouvrage",resultOuvrage.getNom());
        Assert.assertEquals(java.util.Optional.of(3).get(),resultOuvrage.getNombreResaFaites());
        Assert.assertEquals(dateRetourPrevue,resultOuvrage.getDateDeRetourPrevu());
        Assert.assertEquals(java.util.Optional.of(4).get(),resultOuvrage.getNombreDispo());
    }
}
