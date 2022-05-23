package group3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "employee")
public class Employee extends User implements Serializable {


    @Column(name = "address")
    private String address;

    @Column(name = "hours")
    private double hours;

    public Employee() {}

    public Employee(long id, String username, String password, String firstName, String lastName,
                    String email, String phoneNumber, String authLevel, String address, double hours) {
        super(id, username, password, firstName, lastName, email, phoneNumber, authLevel);
        this.address = address;
        this.hours = hours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}
