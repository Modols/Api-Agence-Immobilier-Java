package com.ynov.demo.service;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.Complexe;
import com.ynov.demo.domain.MyService;
import com.ynov.demo.domain.ReservationDate;
import com.ynov.demo.repository.AppartementRepository;
import com.ynov.demo.repository.ReservationDateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ReservationDateService {
    private final ReservationDateRepository reservationDateRepository;
    private AppartementRepository appartementRepository;

    public ReservationDateService(ReservationDateRepository reservationDateRepository, AppartementRepository appartementRepository) {
        this.reservationDateRepository = reservationDateRepository;
        this.appartementRepository = appartementRepository;
    }

    @Transactional
    public List<ReservationDate> getReservationDate() {
            return reservationDateRepository.findAll();
    }

    @Transactional
    public ReservationDate createReservationDate(LocalDate beginDate, LocalDate endDate, Long appartement_id) {
        Appartement appartement = appartementRepository.findAppId(appartement_id);
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setBeginDate( beginDate);
        reservationDate.setEndDate(endDate);
        reservationDateRepository.save(reservationDate);
        appartement.getReservationDates().add(reservationDate);
        return reservationDate;
    }

    @Transactional
    public ReservationDate updateReservationDate(Long id, LocalDate beginDate, LocalDate endDate, Long appartement_id) {
        Appartement oldAppartement = appartementRepository.findAppId(appartement_id);
        ReservationDate reservationDate = reservationDateRepository.findReservationDateById(id);
        oldAppartement.getReservationDates().remove(reservationDate);
        Appartement appartement = appartementRepository.findAppId(appartement_id);
        reservationDate.setBeginDate( beginDate);
        reservationDate.setEndDate(endDate);
        reservationDateRepository.save(reservationDate);
        appartement.getReservationDates().add(reservationDate);
        return reservationDate;
    }

    @Transactional
    public void deleteReservationDate(Long id) {
        ReservationDate reservationDate = reservationDateRepository.findReservationDateById(id);
        reservationDateRepository.delete(reservationDate);
    }
}
