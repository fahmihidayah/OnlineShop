package onlineShop.services;

import onlineShop.domain.Address;

/**
 * Created by Damian Bartos
 * 31.08.2016.
 */
public interface IAddressService {
    Address getAddressById(long addressId);
}
