package onlineShop.dao;

import onlineShop.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
