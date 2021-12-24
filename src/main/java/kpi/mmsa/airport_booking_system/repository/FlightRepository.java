package kpi.mmsa.airport_booking_system.repository;

import kpi.mmsa.airport_booking_system.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Override
    Optional<Flight> findById(Long id);
}
