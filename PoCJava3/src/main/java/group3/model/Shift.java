package group3.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "shift")
public class Shift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "address")
    private String address;

    @Column(name = "time")
    private String time;

    @Column(name = "date")
    private String date;

    @Column(name = "hands_req")
    private int hands_req;

    public Shift() {
    }

    public Shift(Long id, String description, String address, String time, String date, int hands_req) {
        this.id = id;
        this.description = description;
        this.address = address;
        this.time = time;
        this.date = date;
        this.hands_req = hands_req;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHands_req() {
        return hands_req;
    }

    public void setHands_req(int hands_req) {
        this.hands_req = hands_req;
    }
}


