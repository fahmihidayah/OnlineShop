package onlineShop.utility;

import onlineShop.domain.Role;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
public final class RoleName {
    private RoleName(){}

    public static Role ADMIN = new Role("ADMIN");
    public static Role USER = new Role("USER");

//    public static final String ADMIN = "ADMIN";
//    public static final String USER = "USER";
}
