package kpi.mmsa.airport_booking_system.controller;

import kpi.mmsa.airport_booking_system.model.Aircraft;
import kpi.mmsa.airport_booking_system.service.AircraftService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AircraftController {
    private final AircraftService aircraftService;
    public AircraftController(AircraftService aircraftService){
        this.aircraftService = aircraftService;
    }

    @GetMapping(value = "/aircraft")
    public ResponseEntity<List<Aircraft>> getAirports(){
        return ResponseEntity.ok(aircraftService.getAircrafts());
    }

    @GetMapping(value = "/aircraft/{model}")
    public ResponseEntity<Aircraft> getAirport(@PathVariable String model){
        return ResponseEntity.ok(aircraftService.getAircraftByModel(model));
    }

    @PostMapping (value = "/aircraft")
    public ResponseEntity<Aircraft> postAirport(@Valid @RequestBody Aircraft newAircraft){
        return ResponseEntity.ok(aircraftService.saveAircraft(newAircraft));
    }

    @PutMapping(value = "/aircraft/{model}")
    public ResponseEntity<Aircraft> updateAirport(@PathVariable String model, @Valid @RequestBody Aircraft updatedAircraft){
        return ResponseEntity.ok(aircraftService.updateAircraft(model, updatedAircraft));
    }

    @DeleteMapping(value = "/aircraft/{model}")
    public ResponseEntity<String> deleteStatus(@PathVariable String model) {
        return ResponseEntity.ok(aircraftService.deleteAircraftByModel(model));
    }

}