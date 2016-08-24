package onlineShop.dao;

import onlineShop.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Damian Bartos
 * 22.08.2016.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> ffindByCity(String city);
    List<Address> findByZipCode(String zipCode);
}
