package kpi.mmsa.airport_booking_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "flight_number", referencedColumnName = "flight_number")
    private FlightInfo number;

    @NotNull
    @Column(name = "flight_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull
    @Column(name = "flight_status")
    @Enumerated(EnumType.STRING)
    private Enums.Flight_status status;

    @NotNull
    @Column(name = "departure_time")
    @JsonFormat(pattern = "HH:mm")
    private Date departureTime;

    @NotNull
    @Column(name = "arrival_time")
    @JsonFormat(pattern = "HH:mm")
    private Date arrivalTime;

    @NotNull
    @Column(name = "terminal")
    private String terminal;

    @NotNull
    @Column(name = "gate")
    private String gate;

    @NotNull
    @Column(name = "price_economy")
    private int economPrice;

    @NotNull
    @Column(name = "price_business")
    private int businessPrice;

    @NotNull
    @Column(name = "n_available_economy")
    private int nEconom;

    @NotNull
    @Column(name = "n_available_business")
    private int nBusiness;

    public Long getId() {
        return id;
    }

    public FlightInfo getNumber() {
        return number;
    }

    public void setNumber(FlightInfo number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Enums.Flight_status getStatus() {
        return status;
    }

    public void setStatus(Enums.Flight_status status) {
        this.status = status;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public int getEconomPrice() {
        return economPrice;
    }

    public void setEconomPrice(int economPrice) {
        this.economPrice = economPrice;
    }

    public int getBusinessPrice() {
        return businessPrice;
    }

    public void setBusinessPrice(int businessPrice) {
        this.businessPrice = businessPrice;
    }

    public int getNEconom() {
        return nEconom;
    }

    public void setNEconom(int nEconom) {
        this.nEconom = nEconom;
    }

    public int getNBusiness() {
        return nBusiness;
    }

    public void setNBusiness(int nbusiness) {
        this.nBusiness = nbusiness;
    }
}
