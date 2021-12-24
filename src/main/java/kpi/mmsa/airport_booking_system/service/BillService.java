package kpi.mmsa.airport_booking_system.service;

import kpi.mmsa.airport_booking_system.model.Bill;
import kpi.mmsa.airport_booking_system.model.Enums;
import kpi.mmsa.airport_booking_system.model.Flight;
import kpi.mmsa.airport_booking_system.repository.BillRepository;
import kpi.mmsa.airport_booking_system.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final FlightRepository flightRepository;
    public BillService(BillRepository billRepository, FlightRepository flightRepository) {
        this.billRepository = billRepository;
        this.flightRepository = flightRepository;
    }

    public List<Bill> getBills(){
        return billRepository.findAll();
    }

    public Bill getBillById(Long id){
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isEmpty()) { throw new IllegalArgumentException("Bill with this id is not found"); }
        return bill.get();
    }

    public Bill saveBill(Bill newBill){
        Flight flight = newBill.getFlightId();
        if (newBill.getFlightClass() == Enums.Class.Economy){
            if (flight.getNEconom() <= 0){
                throw new IllegalArgumentException("There are not available places at this flight");
            }
            flight.setNEconom(flight.getNEconom() - 1);
            flightRepository.save(flight);

        }
        if (newBill.getFlightClass() == Enums.Class.Business){
            if (flight.getNBusiness() <= 0){
                throw new IllegalArgumentException("There are not available places at this flight");
            }
            flight.setNBusiness(flight.getNBusiness() - 1);
            flightRepository.save(flight);
        }
        return billRepository.save(newBill);
    }

    public Bill updateBillPassenger(Long id, Bill updatedBill){
        Optional<Bill> bill = billRepository.findById(id);
        if (bill.isEmpty()) { throw new IllegalArgumentException("Bill with this id is not found"); }
        Bill oldBill = bill.get();
        oldBill.setPassport(updatedBill.getPassport());
        return billRepository.save(oldBill);
    }

    public String deleteBillById(Long id) {
        Optional<Bill> bills = billRepository.findById(id);
        if (bills.isEmpty()) { throw new IllegalArgumentException("Bill with this id is not found"); }

        Bill bill = bills.get();
        Flight flight = bill.getFlightId();
        if (bill.getFlightClass() == Enums.Class.Economy){
            flight.setNEconom(flight.getNEconom() + 1);
        }
        if (bill.getFlightClass() == Enums.Class.Business){
            flight.setNBusiness(flight.getNBusiness() + 1);
        }
        billRepository.deleteById(id);
        return "Bill was successfully deleted";
    }
}
