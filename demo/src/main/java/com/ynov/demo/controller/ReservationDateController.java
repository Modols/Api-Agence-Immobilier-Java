package com.ynov.demo.controller;

import com.ynov.demo.domain.MyService;
import com.ynov.demo.domain.ReservationDate;
import com.ynov.demo.service.MyServiceService;
import com.ynov.demo.service.ReservationDateService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class ReservationDateController {
    ReservationDateService reservationDateService;

    public ReservationDateController(ReservationDateService reservationDateService) {
        this.reservationDateService = reservationDateService;
    }

    @GetMapping("/reservationDate")
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationDate> getReservationDate() {
        return reservationDateService.getReservationDate();
    }

    @PostMapping("/reservationDate/create/{appartement_id}/{beginDate}/{endDate}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDate createReservationDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                                 @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                 @PathVariable Long appartement_id) {
        return reservationDateService.createReservationDate(beginDate, endDate, appartement_id);
    }

    @PutMapping("/reservationDate/update/{id}/{beginDate}/{endDate}/{appartement_id}")
    @ResponseStatus(HttpStatus.OK)
    public ReservationDate updateReservationDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                   @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                   @PathVariable Long appartement_id, @PathVariable Long id){
        return reservationDateService.updateReservationDate(id, beginDate, endDate, appartement_id);
    }

    @DeleteMapping("/reservationDate/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteReservationDate(@PathVariable Long id) {
        reservationDateService.deleteReservationDate(id);
    }

}
