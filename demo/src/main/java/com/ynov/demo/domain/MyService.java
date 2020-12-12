package com.ynov.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class MyService {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String detailService;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "Complexe_My_Service",
            joinColumns = { @JoinColumn(name = "my_service_id") },
            inverseJoinColumns = { @JoinColumn(name = "complexe_id") }
    )
    private Set<Complexe> complexes = new HashSet<>();

    public Set<Complexe> getComplexes() {
        return complexes;
    }

    public void setComplexes(Set<Complexe> complexes) {
        this.complexes = complexes;
    }

//    @OneToMany(mappedBy = "MyService")
//    Set<ComplexeMyService> complexeMyServices;


    public Long getId() {
        return id;
    }

    public String getDetailService() {
        return detailService;
    }

    public void setDetailService(String detailService) {
        this.detailService = detailService;
    }


}
