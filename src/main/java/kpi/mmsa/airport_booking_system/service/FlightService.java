package kpi.mmsa.airport_booking_system.service;

import kpi.mmsa.airport_booking_system.model.Flight;
import kpi.mmsa.airport_booking_system.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    private final FlightRepository flightRepository;
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Flight> getFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id){
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isEmpty()) { throw new IllegalArgumentException("Flight with this id is not found"); }
        return flight.get();
    }

    public Flight saveFlight(Flight newFlight){
        return flightRepository.save(newFlight);
    }

    public Flight updateFlight(Long id, Flight updatedFlight){
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isEmpty()) { throw new IllegalArgumentException("Flight with this id is not found"); }
        Flight oldFlight = flight.get();
        oldFlight.setNumber(updatedFlight.getNumber());
        oldFlight.setDate(updatedFlight.getDate());
        oldFlight.setStatus(updatedFlight.getStatus());
        oldFlight.setDepartureTime(updatedFlight.getDepartureTime());
        oldFlight.setArrivalTime(updatedFlight.getArrivalTime());
        oldFlight.setTerminal(updatedFlight.getTerminal());
        oldFlight.setGate(updatedFlight.getGate());
        oldFlight.setEconomPrice(updatedFlight.getEconomPrice());
        oldFlight.setBusinessPrice(updatedFlight.getBusinessPrice());
        oldFlight.setNEconom(oldFlight.getNEconom());
        oldFlight.setNBusiness(updatedFlight.getNBusiness());
        return flightRepository.save(oldFlight);
    }

    public String deleteFlightById(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isEmpty()) { throw new IllegalArgumentException("Flight with this id is not found"); }

        flightRepository.deleteById(id);
        return "Flight was successfully deleted";
    }
}
