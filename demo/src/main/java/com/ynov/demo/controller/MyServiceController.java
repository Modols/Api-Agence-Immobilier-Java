package com.ynov.demo.controller;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.domain.MyService;
import com.ynov.demo.service.MyServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MyServiceController {
    MyServiceService myServiceService;

    public MyServiceController(MyServiceService myServiceService) {
        this.myServiceService = myServiceService;
    }

    @GetMapping("/services")
    @ResponseStatus(HttpStatus.OK)
    public List<MyService> getServices() {
        return myServiceService.getServices();
    }

    @PostMapping("/service/create/{detail_service}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public MyService createService(@PathVariable String detail_service, @PathVariable Long complexe_id) {
        return myServiceService.createService(detail_service, complexe_id);
    }

    @PutMapping("/service/update/{id}/{detail_service}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public MyService updateService(@PathVariable Long id, @PathVariable String detail_service, @PathVariable Long complexe_id){
        return myServiceService.updateService(id, detail_service, complexe_id);
    }

    @DeleteMapping("/service/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMyService(@PathVariable Long id) {
        myServiceService.deleteMyService(id);
    }

}
