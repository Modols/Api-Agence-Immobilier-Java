package com.ynov.demo.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Appartement {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToMany
    @JoinColumn(name="APPARTEMENT_ID")
    private Set<ReservationDate> reservationDates;

    private String name;
    private int nb_couchage;
    private int surface;
    private boolean equipe_bebe;
    private boolean climatisation;
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getEquipe_bebe() {return equipe_bebe;}

    public boolean getClimatisation() {return climatisation;}

    public void setEquipe_bebe(boolean equipe_bebe) {this.equipe_bebe = equipe_bebe;}

    public void setClimatisation(boolean climatisation) {this.climatisation = climatisation;}

    public Long getId() {return id;}

    public void setName(String name) {this.name = name;}

    public String getName() {return name;}

    public int getNb_couchage() {return nb_couchage;}

    public void setNb_couchage(int nb_couchage) {this.nb_couchage = nb_couchage;}

    public int getSurface() {return surface;}

    public void setSurface(int surface) {this.surface = surface;}

    public Set<ReservationDate> getReservationDates() {
        return reservationDates;
    }

    public void setReservationDates(Set<ReservationDate> reservationDates) {
        this.reservationDates = reservationDates;
    }

}
