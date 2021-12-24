package kpi.mmsa.airport_booking_system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "passport_no")
    private User passport;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    private Flight flightId;

    @NotNull
    @Column(name = "class")
    @Enumerated(EnumType.STRING)
    private Enums.Class flightClass;

    public Long getId() {
        return id;
    }

    public User getPassport() {
        return passport;
    }

    public void setPassport(User passport) {
        this.passport = passport;
    }

    public Flight getFlightId() {
        return flightId;
    }

    public void setFlightId(Flight flightId) {
        this.flightId = flightId;
    }

    public Enums.Class getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(Enums.Class clas) {
        this.flightClass = clas;
    }
}
