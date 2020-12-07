package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.repository.AppartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppartementService {
    private final AppartementRepository appartementRepository;

    public AppartementService(AppartementRepository appartementRepository) {
        this.appartementRepository = appartementRepository;
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
}
