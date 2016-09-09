package onlineShop.services;

import onlineShop.domain.Address;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Damian Bartos
 * 30.08.2016.
 */
public interface IUserService {
    User create(User user);

    void deleteUserById(long userId);

    boolean exist(long userId);

    List<User> getAllUsers(Pageable pageable);

    User getUserById(long userId);

    User getUserByUserName(String userName);

    Object getCurrentLoggedUser();

    User changeUserRole(long userId, Role role);

    User updateUserById(long userId, User userData);

    User setAddress(long userId, Address address);
}
