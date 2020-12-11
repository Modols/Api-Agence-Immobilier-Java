package com.ynov.demo.service;

import com.ynov.demo.domain.Complexe;
import com.ynov.demo.repository.ComplexeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplexeService {

    private final ComplexeRepository complexeRepository;

    public ComplexeService(ComplexeRepository complexeRepository) {
        this.complexeRepository = complexeRepository;
    }


    public List<Complexe> getComplexe() {
        return complexeRepository.getComplexeWithAppartements();
    }

//    public Complexe createComplexe() {
//        Complexe complexe = new Complexe();
//        complexe.setName("Complexe_" + Math.random());
//        complexe.setType_complexe("Village Vacance");
//        complexeRepository.save(complexe);
//        return complexe;
//    }


    public Complexe createComplexe(String name, String type_complexe, String pays, String region, String adresse, String gps, String type_lieu) {
        Complexe complexe = new Complexe();
        complexe.setName(name);
//        if (type_complexe == "VillageVacance" || type_complexe == "Residence"){
            complexe.setType_complexe("Village Vacance");
//        }
        complexe.setPays(pays);
        complexe.setRegion(region);
        complexe.setAdresse(adresse);
        complexe.setGps(gps);
        complexe.setType_lieu(type_lieu);
        complexeRepository.save(complexe);
        return complexe;
    }
}
