package com.bibliotheque.modele.entities;

import org.junit.Assert;
import org.junit.Test;

public class UsagerTest {
    @Test
    public void testGettersAndSetters(){
        Usager usager = new Usager();
        usager.setEmail("mon adresse");
        usager.setIdentifiant("francois");
        usager.setNom("proust");
        usager.setPrenom("francois");
        usager.setPassword("password");

        Assert.assertEquals("mon adresse",usager.getEmail());
        Assert.assertEquals("francois",usager.getIdentifiant());
        Assert.assertEquals("password",usager.getPassword());
        Assert.assertEquals("proust",usager.getNom());
        Assert.assertEquals("francois",usager.getPrenom());
    }
}
