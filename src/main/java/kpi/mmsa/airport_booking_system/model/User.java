package kpi.mmsa.airport_booking_system.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "user_info")
public class User {

    @NotNull
    @Column(name = "first_name")
    private String name;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date birth;

    @Id
    @Column(name = "passport_no")
    private String passNo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "passport_date_of_expiry")
    private Date expiry;

    @NotNull
    @Column(name = "nationality")
    private String nationality;

    @NotNull
    @Column(name = "phone_number")
    private String phone;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "user_password")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Enums.Role role;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private Enums.Status status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passId) {
        this.passNo = passId;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enums.Role getRole() {
        return role;
    }

    public void setRole(Enums.Role role) {
        this.role = role;
    }

    public Enums.Status getStatus() {
        return status;
    }

    public void setStatus(Enums.Status status) {
        this.status = status;
    }
}
