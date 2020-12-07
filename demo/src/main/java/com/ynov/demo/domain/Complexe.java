package com.ynov.demo.domain;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Complexe {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String type_complexe;


    @OneToMany
    @JoinColumn(name="COMPLEXE_ID")
    private Set<Appartement> appartements;

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
