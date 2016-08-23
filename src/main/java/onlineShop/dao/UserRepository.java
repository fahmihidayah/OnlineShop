package onlineShop.dao;

import onlineShop.domain.Role;
import onlineShop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Bartos
 * 16.08.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    List<User> findByPhoneNumber(String phoneNumber);
    List<User> findByRole(Role role);
    List<User> findByEmail(String email);
}
