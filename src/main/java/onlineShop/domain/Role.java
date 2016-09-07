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

    @Column(name = "ROLE_NAME")
    private String roleName;

    public static Role ADMIN() {
        return new Role("ADMIN");
    }

    public static Role USER() {
        return new Role("USER");
    }

    protected Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
