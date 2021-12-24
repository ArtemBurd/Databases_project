package kpi.mmsa.airport_booking_system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flight_info")
public class FlightInfo {

    @Id
    @Column(name = "flight_number")
    private String number;

    @NotNull
    @Column(name = "airline")
    private String airline;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aircraft_model", referencedColumnName = "aircraft_model")
    private Aircraft aircraftModel;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "from_IATA", referencedColumnName = "IATA_name")
    private Airport from;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "destination_IATA", referencedColumnName = "IATA_name")
    private Airport destination;

    public String getNumber() {
        return number;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Aircraft getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(Aircraft aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public Airport getFrom() {
        return from;
    }

    public void setFrom(Airport from) {
        this.from = from;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }
}
