package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.AppartementDto;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.repository.AppartementRepository;
import com.ynov.demo.repository.ComplexeRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    public List<Appartement> getAllAppartements() {
        return appartementRepository.findAll();
    }

    @Transactional
    public Appartement createApp(String name, int surface, int nb_couchage, boolean equipe_bebe,
                                 boolean climatisation, Long complexe_id, int price) {
        Complexe complexe = complexeRepository.findComplexeById(complexe_id);
        Appartement app = new Appartement();
        app.setSurface(surface);
        app.setPrice(price);
        app.setName(name);
        app.setNb_couchage(nb_couchage);
        app.setClimatisation(equipe_bebe);
        app.setEquipe_bebe(climatisation);
        appartementRepository.save(app);
        complexe.getAppartements().add(app);
        return app;
    }

    @Transactional
    public Appartement updateApp(Long id, String name, int surface, int nb_couchage, boolean equipe_bebe,
                                 boolean climatisation, Long complexe_id, int price) {
        Complexe oldComplexe = complexeRepository.findComplexeIdWithAnAppId(id);
        Appartement app = appartementRepository.findAppId(id);
        oldComplexe.getAppartements().remove(app);
        Complexe complexe = complexeRepository.findComplexeById(complexe_id);
        app.setSurface(surface);
        app.setName(name);
        app.setPrice(price);
        app.setNb_couchage(nb_couchage);
        app.setClimatisation(equipe_bebe);
        app.setEquipe_bebe(climatisation);
        appartementRepository.save(app);
        complexe.getAppartements().add(app);
        return app;
    }

    public void deleteApp(Long id) {
        Appartement app = appartementRepository.findAppId(id);
        appartementRepository.delete(app);
    }

    public List<Appartement> getAllAppartementForARegion(String region) {
        return appartementRepository.findAllAppartementForARegion(region);
    }

    public List<Appartement> getAllAppartementForAPiscine() {
        return appartementRepository.findAllAppartementForAPiscine();
    }

    public List<Appartement> getAllAppartementInMontagne() {
        return appartementRepository.findAllAppartementInMontagne();
    }

    public List<Appartement> getAllAppartementFreeBetweenTwoDate(LocalDate beginDate, LocalDate endDate) {
        return appartementRepository.findAllAppartementFreeBetweenTwoDate(beginDate, endDate);
    }

    public List<AppartementDto> getAppartementWhithIdAndPrice(LocalDate beginDate, LocalDate endDate) {
        return appartementRepository.findAppartementWhithIdAndPrice(beginDate, endDate);
    }

    public List<AppartementDto> getAppartementDto(LocalDate beginDate, LocalDate endDate, String region) {
        return appartementRepository.findAppartementDto(beginDate, endDate, region);
    }
}
//findAppartementWhithIdAndPrice
