package com.ynov.demo.controller;

import com.ynov.demo.domain.Complexe;
import com.ynov.demo.service.ComplexeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ComplexeController {
    ComplexeService complexeservice;

    public ComplexeController(ComplexeService complexeservice) {
        this.complexeservice = complexeservice;
    }

    @GetMapping("/complexes")
    @ResponseStatus(HttpStatus.OK)
    public List<Complexe> getComplexe() { return complexeservice.getComplexe(); }

    @PostMapping("/complexe/create/{name}/{type_complexe}/{pays}/{region}/{adresse}/{gps}/{type_lieu}")
    @ResponseStatus(HttpStatus.OK)
    public Complexe createComplexe(@PathVariable String name, @PathVariable String type_complexe, @PathVariable String pays, @PathVariable String region, @PathVariable String adresse, @PathVariable String gps, @PathVariable String type_lieu) {
        return complexeservice.createComplexe(name, type_complexe, pays, region, adresse, gps, type_lieu);
    }

    @PutMapping("/complexe/update/{id}/{name}/{type_complexe}/{pays}/{region}/{adresse}/{gps}/{type_lieu}")
    @ResponseStatus(HttpStatus.OK)
    public Complexe updateComplexe(@PathVariable Long id, @PathVariable String name, @PathVariable String type_complexe, @PathVariable String pays, @PathVariable String region, @PathVariable String adresse, @PathVariable String gps, @PathVariable String type_lieu) {
        return complexeservice.updateComplexe(id, name, type_complexe, pays, region, adresse, gps, type_lieu);
    }

    @DeleteMapping("/complexe/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteComplexe(@PathVariable Long id) {
        complexeservice.deleteComplexe(id);
    }

    @GetMapping("/complexe/getAllComplexeForAPays/{pays}")
    @ResponseStatus(HttpStatus.OK)
    public List<Complexe> getComplexeForAPays(@PathVariable String pays) {
        return complexeservice.getComplexeForAPays(pays);
    }

}
