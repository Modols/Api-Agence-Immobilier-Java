package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.domain.MyService;
import com.ynov.demo.repository.ComplexeRepository;
import com.ynov.demo.repository.MyServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyServiceService {
    private final MyServiceRepository myServiceRepository;
    private final ComplexeRepository complexeRepository;

    public MyServiceService(MyServiceRepository myServiceRepository, ComplexeRepository complexeRepository) {
        this.myServiceRepository = myServiceRepository;
        this.complexeRepository = complexeRepository;
    }

    @Transactional
    public List<MyService> getServices() {
        return myServiceRepository.getAllServices();
    }

    @Transactional
    public MyService createService(String detail_service, Long complexe_id) {
        Complexe complexe = complexeRepository.findComplexeById(complexe_id);
        MyService myService = new MyService();
        myService.setDetailService(detail_service);
        myServiceRepository.save(myService);
        complexe.getMyServices().add(myService);
        return myService;
    }

    @Transactional
    public MyService updateService(Long id, String detail_service, Long complexe_id) {
        Complexe oldComplexe = complexeRepository.findComplexeById(complexe_id);
        MyService myService = myServiceRepository.findServiceById(id);
        oldComplexe.getAppartements().remove(myService);
        Complexe complexe = complexeRepository.findComplexeById(complexe_id);
        myService.setDetailService(detail_service);
        myServiceRepository.save(myService);
        complexe.getMyServices().add(myService);
        return myService;
    }

    public void deleteMyService(Long id) {
        MyService myService = myServiceRepository.findServiceById(id);
        myServiceRepository.delete(myService);
    }
}
