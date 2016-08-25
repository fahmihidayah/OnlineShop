package onlineShop.services;

import onlineShop.dao.AddressRepository;
import onlineShop.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Damian Bartos
 * 25.08.2016.
 */
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address getAddressById(int addressId){
        return addressRepository.findOne(addressId);
    }

}
