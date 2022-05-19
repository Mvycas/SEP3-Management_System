package group3.model;

import java.io.Serializable;


public class Employee extends User implements Serializable
{
    private String address;

    private double hours;

    public Employee() {}

    public Employee(String address, double hours) {
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
