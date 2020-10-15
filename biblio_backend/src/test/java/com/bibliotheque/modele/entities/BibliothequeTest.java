package com.bibliotheque.modele.entities;

import org.junit.Assert;
import org.junit.Test;

public class BibliothequeTest {

    @Test
    public void testGettersAndSetters(){
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.setBiblioId(1);
        bibliotheque.setLieu("Bibli test");

        Assert.assertEquals(java.util.Optional.of(1).get(), bibliotheque.getBiblioId());
        Assert.assertEquals("Bibli test", bibliotheque.getLieu());
    }
}
