package com.bibliotheque.modele.entities;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class OuvrageTest {
    @Test
    public void testGettersAndSetters(){
        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setAuteur("Frédéric Beigbeder");
        ouvrage.setNom("99 francs");

        Assert.assertEquals("Frédéric Beigbeder",ouvrage.getAuteur());
        Assert.assertEquals("99 francs",ouvrage.getNom());
    }
}
