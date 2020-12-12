package com.ynov.demo.controller;

import com.ynov.demo.domain.MyService;
import com.ynov.demo.service.MyServiceService;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/service/create/{detail_service}")
    @ResponseStatus(HttpStatus.OK)
    public MyService createService(@PathVariable String detail_service) {
        return myServiceService.createService(detail_service);
    }

    @PostMapping("/service/complexe/add/{service_id}/{complexe_id}")
    @ResponseStatus(HttpStatus.OK)
    public void addServiceToComplexe(@PathVariable Long service_id, @PathVariable Long complexe_id) {
        myServiceService.addServiceToComplexe(service_id, complexe_id);
    }
}
