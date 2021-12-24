package kpi.mmsa.airport_booking_system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @Column(name = "aircraft_model")
    private String model;

    @NotNull
    @Column(name = "total_capacity")
    private String capacity;

    @NotNull
    @Column(name = "economy_capacity")
    private String economCapacity;

    @NotNull
    @Column(name = "business_capacity")
    private String businessCapacity;

    public String getModel() {
        return model;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getEconomCapacity() {
        return economCapacity;
    }

    public void setEconomCapacity(String economCapacity) {
        this.economCapacity = economCapacity;
    }

    public String getBusinessCapacity() {
        return businessCapacity;
    }

    public void setBusinessCapacity(String businessCapacity) {
        this.businessCapacity = businessCapacity;
    }
}
