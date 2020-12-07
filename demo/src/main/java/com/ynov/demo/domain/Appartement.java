package com.ynov.demo.domain;

import javax.persistence.*;

@Entity
//@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Appartement {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int nb_couchage;
    private int surface;


}
