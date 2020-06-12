package org.dbs.business;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Em")
public class Employee extends Role {

    protected Date dateEntree;
    protected Date dateSortie;
    protected Boolean actif;

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", person=" + person +
                ", description='" + description + '\'' +
                ", actif=" + actif +
                ", dateEntree=" + dateEntree +
                ", dateSortie=" + dateSortie +
                '}';
    }
}
