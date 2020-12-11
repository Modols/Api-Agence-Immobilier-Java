package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.repository.AppartementRepository;
import com.ynov.demo.repository.ComplexeRepository;
import org.hibernate.Session;
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

    public void generateAppartements() {
        Appartement app = new Appartement();
        app.setName("pose");
        appartementRepository.save(app);

        app = new Appartement();
        app.setName("wsh");
        appartementRepository.save(app);
    }

//    @Transactional
//    public void generateComplexe() {
//        Complexe complexe = new Complexe();
//        complexe.setName("Complexe_" + Math.random());
//        complexe.setType_complexe("Village Vacance");
//        complexeRepository.save(complexe);
//
//        complexe.setAppartements(new HashSet<>());
//        Appartement app = new Appartement();
//        app.setName("APP-" + Math.random());
//        app.setSurface(25);
//        app.setEquipe_bebe(true);
//        app.setClimatisation(true);
//        app.setNb_couchage(2);
//        appartementRepository.save(app);
//        complexe.getAppartements().add(app);
//
//        app = new Appartement();
//        app.setName("APP2-" + Math.random());
//        app.setSurface(12);
//        app.setEquipe_bebe(false);
//        app.setClimatisation(false);
//        app.setNb_couchage(1);
//
//        appartementRepository.save(app);
//        complexe.getAppartements().add(app);
////        complexeRepository.save(complexe);
//    }




//    public List<Appartement> getAppartementsArguments() {
//        return appartementRepository.findWithAllArguments();
//    }

    public List<Appartement> getAllAppartements() {
        return appartementRepository.findAll();
    }


//    public Appartement updateApp(Long id, int surface, int nb_couchage, boolean bb, boolean clim){
//
//    }


//        Complexe complexe = new Complexe();
//        complexe.setName("Complexe_" + Math.random());
//        complexe.setType_complexe("Village Vacance");
//        complexeRepository.save(complexe);
//
//        complexe.setAppartements(new HashSet<>());
//        Appartement app = new Appartement();
//        app.setName("APP-" + Math.random());
//        app.setSurface(25);
//        app.setEquipe_bebe(true);
//        app.setClimatisation(true);
//        app.setNb_couchage(2);
//        appartementRepository.save(app);
//        complexe.getAppartements().add(app);

    @Transactional
    public Appartement createApp(String name, int surface, int nb_couchage, boolean equipe_bebe,
                                 boolean climatisation, Long complexe_id) {
        Complexe complexe = complexeRepository.findComplexeById(complexe_id);
        Appartement app = new Appartement();
        app.setSurface(surface);
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
                                 boolean climatisation, Long complexe_id) {
        Complexe oldComplexe = complexeRepository.findComplexeIdWithAnAppId(id);
        Appartement app = appartementRepository.findAppId(id);
        oldComplexe.getAppartements().remove(app);
        Complexe complexe = complexeRepository.findComplexeById(complexe_id);
        app.setSurface(surface);
        app.setName(name);
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
}
