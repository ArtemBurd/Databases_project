package kpi.mmsa.airport_booking_system.service;

import kpi.mmsa.airport_booking_system.model.FlightInfo;
import kpi.mmsa.airport_booking_system.repository.FlightInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightInfoService {
    private final FlightInfoRepository flightInfoRepository;
    public FlightInfoService(FlightInfoRepository flightInfoRepository) {
        this.flightInfoRepository = flightInfoRepository;
    }

    public List<FlightInfo> getFlights(){
        return flightInfoRepository.findAll();
    }

    public FlightInfo getFlightByNumber(String number){
        Optional<FlightInfo> flight = flightInfoRepository.findByNumber(number);
        if (flight.isEmpty()) { throw new IllegalArgumentException("Flight with this number is not found"); }
        return flight.get();
    }

    public FlightInfo saveFlight(FlightInfo newFlight){
        return flightInfoRepository.save(newFlight);
    }

    public FlightInfo updateFlight(String number, FlightInfo updatedFlight){
        Optional<FlightInfo> flight = flightInfoRepository.findByNumber(number);
        if (flight.isEmpty()) { throw new IllegalArgumentException("Flight with this number is not found"); }
        FlightInfo oldFlight = flight.get();
        oldFlight.setAirline(updatedFlight.getAirline());
        oldFlight.setAircraftModel(updatedFlight.getAircraftModel());
        oldFlight.setFrom(updatedFlight.getFrom());
        oldFlight.setDestination(updatedFlight.getDestination());
        return flightInfoRepository.save(oldFlight);
    }

    public String deleteFlightByNumber(String number) {
        Optional<FlightInfo> flight = flightInfoRepository.findByNumber(number);
        if (flight.isEmpty()) { throw new IllegalArgumentException("Flight with this number is not found"); }

        flightInfoRepository.deleteById(number);
        return "General flight information about " + number + " was successfully deleted";
    }
}
