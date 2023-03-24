package si.systemair.imenik.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String surname;
    @Getter @Setter
    private String company;
    @Getter @Setter
    private String jobTitle;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String businessPhone;
    @Getter @Setter
    private String mobilePhone;
    @Getter @Setter
    private Integer number;
    @Getter @Setter
    private Integer postcode;
    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private Oddelek department;

    public User() {

    }
    public User(String name, String surname, String company, String email, Oddelek department){
        this();
        this.name = name;
        this.surname = surname;
        this.company = company;
        this.email = email;
        this.department = department;
    }
    public User(String name, String surname, String company, String email, String jobTitle, String businessPhone, String mobilePhone, Integer number, Integer postcode, Oddelek department){
        this(name, surname,company, email, department);
        this.jobTitle = jobTitle;
        this.businessPhone = businessPhone;
        this.mobilePhone = mobilePhone;
        this.number = number;
        this.postcode = postcode;
    }
}
