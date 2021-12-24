package kpi.mmsa.airport_booking_system.controller;

import kpi.mmsa.airport_booking_system.model.Flight;
import kpi.mmsa.airport_booking_system.service.FlightService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FlightController {
    private final FlightService flightService;
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    public FlightService getFlightService() {
        return flightService;
    }

    @GetMapping(value = "/flight")
    public ResponseEntity<List<Flight>> getFlights(){
        return ResponseEntity.ok(flightService.getFlights());
    }

    @GetMapping(value = "/flight/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id){
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @PostMapping(value = "/flight")
    public ResponseEntity<Flight> postFlight(@Valid @RequestBody Flight newFlight){
        return ResponseEntity.ok(flightService.saveFlight(newFlight));
    }

    @PutMapping(value = "/flight/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @Valid @RequestBody Flight updatedFlight){
        return ResponseEntity.ok(flightService.updateFlight(id, updatedFlight));
    }

    @DeleteMapping(value = "/flight/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.deleteFlightById(id));
    }
}
