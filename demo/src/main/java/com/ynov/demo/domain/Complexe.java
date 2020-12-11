package com.ynov.demo.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Complexe {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String type_complexe;
    private String pays;
    private String region;
    private String adresse;
    private String gps;
    private String type_lieu;

    @OneToMany
    @JoinColumn(name="COMPLEXE_ID")
    private Set<Appartement> appartements;


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getType_lieu() {
        return type_lieu;
    }

    public void setType_lieu(String type_lieu) {
        this.type_lieu = type_lieu;
    }











    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType_complexe() {
        return type_complexe;
    }

    public void setType_complexe(String type_complexe) {
        this.type_complexe = type_complexe;
    }

    public void setAppartements(Set<Appartement> app) {
        this.appartements = app;
    }

    public Set<Appartement> getAppartements() {
        return appartements;
    }


}
