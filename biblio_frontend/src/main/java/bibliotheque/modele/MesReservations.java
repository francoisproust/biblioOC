package bibliotheque.modele;

import java.io.Serializable;
import java.util.Date;

public class MesReservations implements Serializable {
    Integer ouvrageId;
    String nomOuvrage;
    Integer rang;
    Date dateDeRetour;

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

    public String getNomOuvrage() {
        return nomOuvrage;
    }

    public void setNomOuvrage(String nomOuvrage) {
        this.nomOuvrage = nomOuvrage;
    }

    public Integer getRang() {
        return rang;
    }

    public void setRang(Integer rang) {
        this.rang = rang;
    }

    public Date getDateDeRetour() {
        return dateDeRetour;
    }

    public void setDateDeRetour(Date dateDeRetour) {
        this.dateDeRetour = dateDeRetour;
    }
}
