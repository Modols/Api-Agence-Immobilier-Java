package com.ynov.demo.repository;

import com.ynov.demo.domain.Appartement;
import com.ynov.demo.domain.AppartementDto;
import com.ynov.demo.domain.Complexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppartementRepository extends JpaRepository<Appartement, Long> {
    @Query(value = "SELECT a.* FROM appartement a JOIN complexe c ON a.complexe_id = c.id \n" +
            "WHERE c.region = :#{#region}", nativeQuery = true)
    List<Appartement> findAllAppartementForARegion(@Param("region") String region);

    @Query(value = "SELECT a FROM Appartement a where a.id = :#{#id} ")
    Appartement findAppId(@Param("id") Long id);

    @Query(value = "SELECT a.* FROM appartement a JOIN complexe c ON a.complexe_id = c.id \n" +
            "WHERE a.complexe_id = :#{#id}", nativeQuery = true)
    List<Appartement> findAppartementsWithComplexeId(@Param("id") Long id);

    @Query(value = "SELECT a.* FROM appartement a JOIN complexe c ON a.complexe_id = c.id \n" +
            "JOIN my_service s ON c.id = s.complexe_id \n" +
            "WHERE s.detail_service = 'piscine'", nativeQuery = true)
    List<Appartement> findAllAppartementForAPiscine();

    @Query(value = "SELECT a.* FROM appartement a JOIN complexe c ON a.complexe_id = c.id \n" +
            "WHERE c.type_lieu = 'montagne'", nativeQuery = true)
    List<Appartement> findAllAppartementInMontagne();

    @Query(
            value = "select * " +
                    "from appartement a " +
                    "inner join reservation_date r " +
                    "on r.appartement_id = a.id " +
                    "where   (:beginDate < r.begin_date and :endDate < r.begin_date )" +
                    "OR ( :beginDate > r.end_date and :endDate > r.end_date)",
            nativeQuery = true
    )
    List<Appartement> findAllAppartementFreeBetweenTwoDate(LocalDate beginDate, LocalDate endDate);

    @Query(value = "SELECT NEW com.ynov.demo.domain.AppartementDto(a.id, c.type_lieu, a.price) " +
                    "from Complexe c " +
                    "join c.appartements a" +
                    " join a.reservationDates d " +
                    "WHERE (:beginDate < d.beginDate and :endDate < d.beginDate ) " +
                    "AND LOWER(c.type_lieu) = 'mer' " +
                    "OR ( :beginDate > d.endDate and :endDate > d.endDate) " +
                    "order by a.price DESC")
    List<AppartementDto> findAppartementWhithIdAndPrice(LocalDate beginDate, LocalDate endDate);

    @Query(value = "SELECT NEW com.ynov.demo.domain.AppartementDto(a.id, c.type_lieu, a.price, c.name) " +
            "from Complexe c " +
            "join c.appartements a" +
            " join a.reservationDates d " +
            " join c.myServices s " +
            "WHERE  ( LOWER(c.type_lieu) = 'mer' and LOWER(s.detailService) = 'piscine' and c.region = :region and a.nb_couchage >= 4 ) " +
            "AND ( (:beginDate < d.beginDate and :endDate < d.beginDate ) " +
            "OR ( :beginDate > d.endDate and :endDate > d.endDate) ) " +
            "order by a.price ASC")
    List<AppartementDto> findAppartementDto(LocalDate beginDate, LocalDate endDate, String region);

}
