package kpi.mmsa.airport_booking_system.service;

import kpi.mmsa.airport_booking_system.model.Aircraft;
import kpi.mmsa.airport_booking_system.repository.AircraftRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {
    private final AircraftRepository aircraftRepository;
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAircrafts(){
        return aircraftRepository.findAll();
    }

    public Aircraft getAircraftByModel(String model){
        Optional<Aircraft> aircraft = aircraftRepository.findByModel(model);
        if (aircraft.isEmpty()) { throw new IllegalArgumentException("This aircraft model is not found"); }
        return aircraft.get();
    }

    public Aircraft saveAircraft(Aircraft newAircraft){
        return aircraftRepository.save(newAircraft);
    }

    public Aircraft updateAircraft(String model, Aircraft updatedAircraft){
        Optional<Aircraft> aircraft = aircraftRepository.findByModel(model);
        if (aircraft.isEmpty()) { throw new IllegalArgumentException("This aircraft model is not found"); }
        Aircraft oldAircraft = aircraft.get();
        oldAircraft.setCapacity(updatedAircraft.getCapacity());
        oldAircraft.setEconomCapacity(updatedAircraft.getEconomCapacity());
        oldAircraft.setBusinessCapacity(updatedAircraft.getBusinessCapacity());
        return aircraftRepository.save(oldAircraft);
    }

    public String deleteAircraftByModel(String model) {
        Optional<Aircraft> aircraft = aircraftRepository.findByModel(model);
        if (aircraft.isEmpty()) { throw new IllegalArgumentException("This aircraft model is not found"); }

        aircraftRepository.deleteById(model);
        return "Aircraft was successfully deleted";
    }
}