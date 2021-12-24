package kpi.mmsa.airport_booking_system.repository;

import kpi.mmsa.airport_booking_system.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    @Override
    Optional <Bill> findById(Long id);
}
