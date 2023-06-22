package si.systemair.imenik.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String jobTitle;

    private String email;

    private String businessPhone;

    private String mobilePhone;

    private Integer number;

    private Integer postcode;

    private String department;

    private Integer priority;

    public User() {

    }
    public User(String name, String surname, String email, String department, Integer priority){
        this();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
        this.priority = priority;
    }
    public User(String name, String surname, String email, String jobTitle, String businessPhone, String mobilePhone, Integer number, Integer postcode, String department, Integer priority){
        this(name, surname, email, department, priority);
        this.jobTitle = jobTitle;
        this.businessPhone = businessPhone;
        this.mobilePhone = mobilePhone;
        this.number = number;
        this.postcode = postcode;
    }
}
