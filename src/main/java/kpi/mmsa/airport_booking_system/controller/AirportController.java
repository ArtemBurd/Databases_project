package kpi.mmsa.airport_booking_system.controller;

import kpi.mmsa.airport_booking_system.model.Airport;
import kpi.mmsa.airport_booking_system.service.AirportService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AirportController {
    private final AirportService airportService;
    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @GetMapping(value = "/airport")
    public ResponseEntity<List<Airport>> getAircrafts(){
        return ResponseEntity.ok(airportService.getAirports());
    }

    @GetMapping(value = "/airport/{iata}")
    public ResponseEntity<Airport> getAirport(@PathVariable String iata){
        return ResponseEntity.ok(airportService.getAirportByIata(iata));
    }

    @GetMapping(value = "/airport/time/{iata}")
    public ResponseEntity<String> getAirportCurrentTime(@PathVariable String iata){
        return ResponseEntity.ok(airportService.getAirportCurrentTime(iata));
    }

    @PostMapping (value = "/airport")
    public ResponseEntity<Airport> postAirport(@Valid @RequestBody Airport newAirport){
        return ResponseEntity.ok(airportService.saveAirport(newAirport));
    }

    @PutMapping(value = "/airport/{iata}")
    public ResponseEntity<Airport> updateAirport(@PathVariable String iata, @Valid @RequestBody Airport updatedAirport){
        return ResponseEntity.ok(airportService.updateAirport(iata, updatedAirport));
    }

    @DeleteMapping(value = "/airport/{iata}")
    public ResponseEntity<String> deleteStatus(@PathVariable String iata) {
        return ResponseEntity.ok(airportService.deleteAirportById(iata));
    }

}
