package onlineShop.domain;

import javax.persistence.*;

/**
 * Created by Damian Bartos
 * 21.08.2016.
 */
@Entity
@Table(name = "ROLES")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", unique = true)
    private Integer userId;

    @Column(name = "ROLE")
    private String role;

    public static Role ADMIN() {
        return new Role("ROLE_ADMIN");
    }

    public static Role USER() {
        return new Role("ROLE_USER");
    }

    protected Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userId=" + userId +
                ", role='" + role + '\'' +
                '}';
    }
}
