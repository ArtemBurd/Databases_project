package kpi.mmsa.airport_booking_system.controller;

import kpi.mmsa.airport_booking_system.model.FlightInfo;
import kpi.mmsa.airport_booking_system.service.FlightInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FlightInfoController {
    private final FlightInfoService flightInfoService;
    public FlightInfoController(FlightInfoService flightInfoService){
        this.flightInfoService = flightInfoService;
    }

    @GetMapping(value = "/flight-info")
    public ResponseEntity<List<FlightInfo>> getFlights(){
        return ResponseEntity.ok(flightInfoService.getFlights());
    }

    @GetMapping(value = "/flight-info/{number}")
    public ResponseEntity<FlightInfo> getFlight(@PathVariable String number){
        return ResponseEntity.ok(flightInfoService.getFlightByNumber(number));
    }

    @PostMapping (value = "/flight-info")
    public ResponseEntity<FlightInfo> postFlight(@Valid @RequestBody FlightInfo newFlight){
        return ResponseEntity.ok(flightInfoService.saveFlight(newFlight));
    }

    @PutMapping(value = "/flight-info/{number}")
    public ResponseEntity<FlightInfo> updateFlight(@PathVariable String number, @Valid @RequestBody FlightInfo updatedFlight){
        return ResponseEntity.ok(flightInfoService.updateFlight(number, updatedFlight));
    }

    @DeleteMapping(value = "/flight-info/{number}")
    public ResponseEntity<String> deleteFlight(@PathVariable String number) {
        return ResponseEntity.ok(flightInfoService.deleteFlightByNumber(number));
    }
}
