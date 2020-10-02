package bibliotheque.modele;

import java.io.Serializable;
import java.util.Date;

public class Exemplaire implements Serializable {
    private Integer exemplaireId;
    private Date dateDebut;
    private Date dateFin;
    private Boolean prolongation;
    private Boolean disponible;
    private Ouvrage ouvrage;

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Integer getExemplaireId() {
        return exemplaireId;
    }

    public void setExemplaireId(Integer exemplaireId) {
        this.exemplaireId = exemplaireId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getProlongation() {
        return prolongation;
    }

    public void setProlongation(Boolean prolongation) {
        this.prolongation = prolongation;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }
}
