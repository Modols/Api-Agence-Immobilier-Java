package com.ynov.demo.controller;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.AppartementDto;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.service.AppartementService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<Appartement> getAllAppartements() {
        return appartementService.getAllAppartements();
    }

    @PostMapping("/appartement/create/{name}/{surface}/{nb_couchage}/{equipe_bebe}/{climatisation}/{price}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement createAppartement(@PathVariable String name, @PathVariable int surface, @PathVariable int price,
                                         @PathVariable int nb_couchage, @PathVariable boolean equipe_bebe,
                                         @PathVariable boolean climatisation, @PathVariable Long complexe_id) {
        Appartement appModif = appartementService.createApp(name, surface, nb_couchage, equipe_bebe, climatisation, complexe_id, price);
        return appModif;
    }

    @PutMapping("/appartement/update/{id}/{name}/{surface}/{nb_couchage}/{equipe_bebe}/{climatisation}/{price}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public Appartement updateAppartement(@PathVariable Long id, @PathVariable String name, @PathVariable int price,
                                         @PathVariable int nb_couchage, @PathVariable boolean equipe_bebe,@PathVariable int surface,
                                         @PathVariable boolean climatisation, @PathVariable Long complexe_id) {
        Appartement appModif = appartementService.updateApp(id, name, surface, nb_couchage, equipe_bebe, climatisation, complexe_id, price);
        return appModif;
    }

    @DeleteMapping("/appartement/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAppartement(@PathVariable Long id) {
         appartementService.deleteApp(id);
    }

    @GetMapping("/appartements/getAllAppartementForARegion/{region}")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement>  getAllAppartementForARegion(@PathVariable String region) {
        return appartementService.getAllAppartementForARegion(region);
    }

    @GetMapping("/appartements/getAllAppartementForAPiscine")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement>  getAllAppartementForAPiscine() {
        return appartementService.getAllAppartementForAPiscine();
    }

    @GetMapping("/appartements/getAllAppartementInMontagne")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement>  getAllAppartementInMontagne() {
        return appartementService.getAllAppartementInMontagne();
    }

    @GetMapping("/appartements/getAllAppartementFreeBetweenTwoDate/{beginDate}/{endDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<Appartement>  getAllAppartementFreeBetweenTwoDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                                                  @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return appartementService.getAllAppartementFreeBetweenTwoDate(beginDate, endDate);
    }

    @GetMapping("/appartements/getAppartementWhithIdAndPrice/{beginDate}/{endDate}")
    @ResponseStatus(HttpStatus.OK)
    public List<AppartementDto>  getAppartementWhithIdAndPrice(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return appartementService.getAppartementWhithIdAndPrice(beginDate, endDate);
    }

    @GetMapping("/appartements/getAppartementDto/{beginDate}/{endDate}/{region}")
    @ResponseStatus(HttpStatus.OK)
    public List<AppartementDto>  getAppartementDto(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                                               @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                   @PathVariable String region) {
        return appartementService.getAppartementDto(beginDate, endDate, region);
    }

}
