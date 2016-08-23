package onlineShop.dao;

import onlineShop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByRoleName(String roleName);
}
