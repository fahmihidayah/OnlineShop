package onlineShop.dao;

import onlineShop.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
