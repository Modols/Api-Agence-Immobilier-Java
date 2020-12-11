package com.ynov.demo.controller;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.service.AppartementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class AppartementController {
    AppartementService appartementService;

    public AppartementController(AppartementService appartementService) {
        this.appartementService = appartementService;
    }


    @GetMapping("/appartements")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement> getAllAppartements() {
        return appartementService.getAllAppartements();
    }


    @PostMapping("/appartement/create/{name}/{surface}/{nb_couchage}/{equipe_bebe}/{climatisation}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement createAppartement(@PathVariable String name, @PathVariable int surface,
                                         @PathVariable int nb_couchage, @PathVariable boolean equipe_bebe,
                                         @PathVariable boolean climatisation, @PathVariable Long complexe_id) {
        Appartement appModif = appartementService.createApp(name, surface, nb_couchage, equipe_bebe, climatisation, complexe_id);
        return appModif;

    }


    @PutMapping("/appartement/update/{id}/{name}/{surface}/{nb_couchage}/{equipe_bebe}/{climatisation}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement updateAppartement(@PathVariable Long id, @PathVariable String name, @PathVariable int surface,
                                         @PathVariable int nb_couchage, @PathVariable boolean equipe_bebe,
                                         @PathVariable boolean climatisation, @PathVariable Long complexe_id) {
        Appartement appModif = appartementService.updateApp(id, name, surface, nb_couchage, equipe_bebe, climatisation, complexe_id);
        return appModif;

    }

    @DeleteMapping("/appartement/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAppartement(@PathVariable Long id) {
         appartementService.deleteApp(id);
    }


//    @GetMapping("/appartements/generate")
//    @ResponseStatus(HttpStatus.OK)
//    public void generateAppartements() {
//        appartementService.generateAppartements();
//    }
}
