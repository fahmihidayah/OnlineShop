package onlineShop.services;

import onlineShop.dao.AddressRepository;
import onlineShop.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian Bartos
 * 25.08.2016.
 */
@Service
//@Transactional
public class AddressService implements IAddressService{
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Address getAddressById(long addressId){
        return addressRepository.findOne(addressId);
    }

}
