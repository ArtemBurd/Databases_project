package kpi.mmsa.airport_booking_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    @Column(name = "IATA_name")
    private String iata;

    @NotNull
    @Column(name = "airport_name")
    private String name;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "country")
    private String country;

    @NotNull
    @Column(name = "UTC_time_zone")
    private String time_zone;

    public String getIata() {
        return iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return time_zone;
    }

    public void setTimeZone(String time_zone) {
        this.time_zone = time_zone;
    }

}
