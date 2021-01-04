package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.repository.AppartementRepository;
import com.ynov.demo.repository.ComplexeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ComplexeService {
    private final ComplexeRepository complexeRepository;
    private AppartementRepository appartementRepository;

    public ComplexeService(ComplexeRepository complexeRepository, AppartementRepository appartementRepository) {
        this.complexeRepository = complexeRepository;
        this.appartementRepository = appartementRepository;
    }

    public List<Complexe> getComplexe() {
        List<Complexe> complexes = complexeRepository.getAllComplexe();
        return complexes;
    }

    public Complexe createComplexe(String name, String type_complexe, String pays, String region, String adresse, String gps, String type_lieu) {
        Complexe complexe = new Complexe();
        complexe.setName(name);
        complexe.setType_complexe(type_complexe);
        complexe.setPays(pays);
        complexe.setRegion(region);
        complexe.setAdresse(adresse);
        complexe.setGps(gps);
        complexe.setType_lieu(type_lieu);
        complexeRepository.save(complexe);
        return complexe;
    }

    @Transactional
    public Complexe updateComplexe(Long id, String name, String type_complexe, String pays,
                                   String region, String adresse, String gps, String type_lieu) {
        Complexe complexe = complexeRepository.findComplexeById(id);
        complexe.setName(name);
        complexe.setType_complexe(type_complexe);
        complexe.setPays(pays);
        complexe.setRegion(region);
        complexe.setAdresse(adresse);
        complexe.setGps(gps);
        complexe.setType_lieu(type_lieu);
        complexeRepository.save(complexe);
        System.out.println(complexe.getAppartements());
        return complexe;
    }

    public void deleteComplexe(Long id) {
        Complexe complexe = complexeRepository.findComplexeById(id);
        List<Appartement> apps = appartementRepository.findAppartementsWithComplexeId(id);
        for (Appartement temp : apps) {
            appartementRepository.delete(temp);
        }
        complexeRepository.delete(complexe);
    }

    public List<Complexe> getComplexeForAPays(String pays) {
        return complexeRepository.findAllComplexeForAPays(pays);
    }

}
