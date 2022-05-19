package group3.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "employee")
public class Employee extends User implements Serializable {


    @Column(name = "address")
    private String address;

    @Column(name = "hours")
    private String hours;

    public Employee() {}

    public Employee(String address, String hours) {
        this.address = address;
        this.hours = hours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}
