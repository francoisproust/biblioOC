package com.bibliotheque.mapping;

import org.junit.Assert;
import org.junit.Test;

public class CreerReservationTest {
    @Test
    public void testGettersAndSetters(){
        CreerReservation creerReservation = new CreerReservation();
        creerReservation.setOuvrageId(1);
        creerReservation.setUsagerId(3);

        Assert.assertEquals(java.util.Optional.of(1).get(),creerReservation.getOuvrageId());
        Assert.assertEquals(java.util.Optional.of(3).get(),creerReservation.getUsagerId());
    }
}
