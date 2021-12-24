package kpi.mmsa.airport_booking_system.repository;

import kpi.mmsa.airport_booking_system.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String> {
    Optional <Airport> findByIata(String iata);
}
