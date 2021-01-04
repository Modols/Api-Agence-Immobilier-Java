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

//    public List<Complexe> getComplexeWithAppartements() {
//        return complexeRepository.getComplexeWithAppartements();
//    }

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
//        on récupere le complexe avec son id
//        on boucle sur tous les appartement avec complexe.getAppartements()
//        on les deletes tous sur le repository puis on delete le complexe du repos
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



    public void addServiceToComplexe(Long complex_id, Long my_service_id) {
//        Set<>

    }

    public void givenData_whenInsert_thenCreatesMtoMrelationship() {
//        String[] serviceData = { "Peter Oven", "Allan Norman" };
//        String[] complexeData = { "IT Project", "Networking Project" };
//        Set<Project> projects = new HashSet<>();
//
//        for (String proj : complexeData) {
//            projects.add(new Project(proj));
//        }
//
//        for (String emp : employeeData) {
//            Employee employee = new Employee(emp.split(" ")[0],
//                    emp.split(" ")[1]);
//
//            assertEquals(0, employee.getProjects().size());
//            employee.setProjects(projects);
//            session.persist(employee);
//
//            assertNotNull(employee);
//        }
    }
}
