package kpi.mmsa.airport_booking_system.repository;

import kpi.mmsa.airport_booking_system.model.FlightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightInfoRepository extends JpaRepository<FlightInfo, String> {
    Optional<FlightInfo> findByNumber(String number);
}
