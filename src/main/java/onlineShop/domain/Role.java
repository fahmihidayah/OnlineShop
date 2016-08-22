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
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "ROLE_NAME")
    private String roleName;

    protected Role(){}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
