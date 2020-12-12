package com.ynov.demo.service;

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
    private MyServiceRepository myServiceRepository;
    private ComplexeRepository complexeRepository;


    public MyServiceService(MyServiceRepository myServiceRepository, ComplexeRepository complexeRepository) {
        this.myServiceRepository = myServiceRepository;
        this.complexeRepository = complexeRepository;

    }

    @Transactional
    public List<MyService> getServices() {
        return myServiceRepository.findAll();
    }

    public MyService createService(String detail_service) {
        MyService myService = new MyService();
        myService.setDetailService(detail_service);
        myServiceRepository.save(myService);
        return myService;
    }

    @Transactional
    public void addServiceToComplexe(Long service_id, Long complexe_id) {
        MyService myService = myServiceRepository.findServiceById(service_id);

        Complexe complexe = complexeRepository.findComplexeById(complexe_id);

//        myService.getComplexes().add(complexe);

        complexe.getMyServices().add(myService);

        myServiceRepository.save(myService);
        complexeRepository.save(complexe);
    }


}
