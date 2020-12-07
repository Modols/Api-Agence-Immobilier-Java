package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.repository.AppartementRepository;
import com.ynov.demo.repository.ComplexeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
public class AppartementService {
    private final AppartementRepository appartementRepository;
    private ComplexeRepository complexeRepository;


    public AppartementService(AppartementRepository appartementRepository, ComplexeRepository complexeRepository) {
        this.appartementRepository = appartementRepository;
        this.complexeRepository = complexeRepository;
    }

    public List<Appartement> getAppartements() {
        return appartementRepository.findAll();
    }


    public void generateAppartements() {
        Appartement app = new Appartement();
        app.setName("pose");
        appartementRepository.save(app);

        app = new Appartement();
        app.setName("wsh");
        appartementRepository.save(app);
    }
    @Transactional
    public void generateComplexe() {
        Complexe complexe = new Complexe();
        complexe.setName("Complexe_" + Math.random());
        complexe.setType_complexe("Village Vacance");
        complexeRepository.save(complexe);
        complexe.setAppartements(new HashSet<>());
        Appartement app = new Appartement();
        app.setName("APP-" + Math.random());
        app.setSurface(12);
        appartementRepository.save(app);
        complexe.getAppartements().add(app);
        app = new Appartement();
        app.setName("APP2-" + Math.random());
        app.setSurface(12);
        appartementRepository.save(app);
        complexe.getAppartements().add(app);
//        complexeRepository.save(complexe);
    }


    public List<Complexe> getComplexe() {
        return complexeRepository.getComplexeWithAppartements();
    }

    public List<Appartement> getAppartementsArguments() {
        return appartementRepository.findWithAllArguments();
    }
}
