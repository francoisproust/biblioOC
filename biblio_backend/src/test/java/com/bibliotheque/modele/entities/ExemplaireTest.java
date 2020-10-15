package com.bibliotheque.modele.entities;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;

public class ExemplaireTest {
    @Test
    public void testGettersAndSetters(){
        Exemplaire exemplaire = new Exemplaire();
        Date dateDebut = Date.valueOf(LocalDate.now());
        Date dateFin = Date.valueOf(LocalDate.now());
        exemplaire.setDateDebut(dateDebut);
        exemplaire.setDateFin(dateFin);
        exemplaire.setProlongation(false);
        exemplaire.setExemplaireId(1);

        Assert.assertEquals(java.util.Optional.of(1).get(), exemplaire.getExemplaireId());
        Assert.assertEquals(dateDebut,exemplaire.getDateDebut());
        Assert.assertEquals(dateFin,exemplaire.getDateFin());
        Assert.assertFalse(exemplaire.getProlongation());
    }
}
