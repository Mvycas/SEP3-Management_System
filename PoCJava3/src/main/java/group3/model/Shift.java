package group3.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shift")
public class Shift implements Serializable {

    private static final long serialVersionUID = -7065683873804696266L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
          name = "employees_enrolled",
          joinColumns = { @JoinColumn(name = "shift_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")})
    private Set<Employee> enrolledEmployees = new HashSet<>();


    private Long employee_id;

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

    public Shift(Long id)
    {
        this.id = id;
    }

    public Shift(Long id, Long employee_id, String description, String address, String time, String date, int hands_req) {
    this.id = id;
    this.employee_id = employee_id;
    this.description = description;
    this.address = address;
    this.time = time;
    this.date = date;
    this.hands_req = hands_req;
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
    public Set<Employee> getEnrolledEmployees() {
        return enrolledEmployees;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public void enrollEmployee(Employee employee) {
        enrolledEmployees.add(employee);
    }
}


