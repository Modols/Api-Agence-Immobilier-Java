package com.ynov.demo.domain;

public class AppartementDto {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType_lieu() {
        return type_lieu;
    }

    public void setType_lieu(String type_lieu) {
        this.type_lieu = type_lieu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private Long id;
    private String type_lieu;
    private int price;
    private String name_village;

    public AppartementDto(Long id, String type_lieu, int price, String name_village) {
        this.id = id;
        this.type_lieu = type_lieu;
        this.price = price;
        this.name_village = name_village;
    }

    public String getName_village() {
        return name_village;
    }

    public void setName_village(String name_village) {
        this.name_village = name_village;
    }

    public AppartementDto(Long id, String type_lieu, int price) {
        this.id = id;
        this.type_lieu = type_lieu;
        this.price = price;
    }


}
