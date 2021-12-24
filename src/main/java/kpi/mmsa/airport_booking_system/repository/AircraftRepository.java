package kpi.mmsa.airport_booking_system.repository;

import kpi.mmsa.airport_booking_system.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {
    Optional <Aircraft> findByModel(String model);
}
