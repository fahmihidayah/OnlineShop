package onlineShop.services;

import onlineShop.dao.AddressRepository;
import onlineShop.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Damian Bartos
 * 25.08.2016.
 */
@Service
@Transactional
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public Address getAddressById(int addressId){
        return addressRepository.findOne(addressId);
    }

}
