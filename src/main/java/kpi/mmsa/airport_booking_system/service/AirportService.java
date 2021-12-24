package kpi.mmsa.airport_booking_system.service;

import kpi.mmsa.airport_booking_system.model.Airport;
import kpi.mmsa.airport_booking_system.repository.AirportRepository;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AirportService {
    private final AirportRepository airportRepository;
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAirports(){
        return airportRepository.findAll();
    }

    public Airport getAirportByIata(String iata){
        Optional<Airport> airport = airportRepository.findByIata(iata);
        if (airport.isEmpty()) { throw new IllegalArgumentException("Airport with this IATA is not found"); }
        return airport.get();
    }

    public Airport saveAirport(Airport newAirport){
        return airportRepository.save(newAirport);
    }

    public Airport updateAirport(String iata, Airport updatedAirport){
        Optional<Airport> airport = airportRepository.findByIata(iata);
        if (airport.isEmpty()) { throw new IllegalArgumentException("Airport with this IATA is not found"); }
        Airport oldAirport = airport.get();
        oldAirport.setName(updatedAirport.getName());
        oldAirport.setCity(updatedAirport.getCity());
        oldAirport.setCountry(updatedAirport.getCountry());
        oldAirport.setTimeZone(updatedAirport.getTimeZone());
        return airportRepository.save(oldAirport);
    }

    public String deleteAirportById(String iata) {
        Optional<Airport> airport = airportRepository.findByIata(iata);
        if (airport.isEmpty()) { throw new IllegalArgumentException("Airport with this IATA is not found"); }

        airportRepository.deleteById(iata);
        return "Airport was successfully deleted";
    }

    public String getAirportCurrentTime(String iata){
        Optional<Airport> airports = airportRepository.findByIata(iata);
        if (airports.isEmpty()) { throw new IllegalArgumentException("Airport with this IATA is not found"); }

        Airport airport = airports.get();
        String city = airport.getCity();
        int timeZoneInMillis = LocalTime.parse(airport.getTimeZone().substring(1)).toSecondOfDay() * 1000;
        if (airport.getTimeZone().charAt(0) == '+'){
            Date date = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 2) + timeZoneInMillis);
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String time = formatter.format(date);
            return "Current time in " + city + " is " + time;
        }
        Date date = new Date(System.currentTimeMillis() - (1000 * 60 * 60 * 2) - timeZoneInMillis);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = formatter.format(date);
        return "Current time in " + city + " is " + time;
    }
}
