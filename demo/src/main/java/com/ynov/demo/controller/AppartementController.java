package com.ynov.demo.controller;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.service.AppartementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/rest")
public class AppartementController {

    AppartementService appartementService;
    public AppartementController(AppartementService appartementService) {
        this.appartementService = appartementService;
    }

    @GetMapping("/appartements")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement> getAppartementsArguments() {
        return appartementService.getAppartementsArguments();
    }

    @GetMapping("/appartements/totale")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement> getAppartements() {
        return appartementService.getAppartements();
    }

    @GetMapping("/appartements/generate")
    @ResponseStatus(HttpStatus.OK)
    public void generateAppartements() {
        appartementService.generateAppartements();
    }

    @GetMapping("/complexe")
    @ResponseStatus(HttpStatus.OK)
    public List<Complexe> getComplexe() { return appartementService.getComplexe(); }



    @GetMapping("/complexe/generate")
    @ResponseStatus(HttpStatus.OK)
    public void generateConcession() {
        appartementService.generateComplexe();
    }
}
