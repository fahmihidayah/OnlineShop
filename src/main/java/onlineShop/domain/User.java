package onlineShop.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by Damian Bartos
 * 16.08.2016.
 */
@Entity
@Table(name = "usertab")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "firstname")
    @Size(min = 5, max = 20)
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    protected User() {}

    public User(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
