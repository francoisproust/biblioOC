package bibliotheque.modele;

import java.io.Serializable;

public class Reserver implements Serializable {
    Integer ouvrageId;
    Integer usagerId;

    public Integer getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Integer ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

    public Integer getUsagerId() {
        return usagerId;
    }

    public void setUsagerId(Integer usagerId) {
        this.usagerId = usagerId;
    }
}
