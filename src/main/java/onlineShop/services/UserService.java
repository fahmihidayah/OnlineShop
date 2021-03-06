package onlineShop.services;

import onlineShop.dao.AddressRepository;
import onlineShop.dao.RoleRepository;
import onlineShop.dao.UserRepository;
import onlineShop.domain.Address;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Damian Bartos
 * 23.08.2016.
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(long userId) {
        User user = userRepository.findOne(userId);
        userRepository.delete(user);
    }

    @Override
    public boolean exist(long userId) {
        return userRepository.exists(userId);
    }

    @Override
    public List<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User getCurrentLoggedUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(userName);
        User one = userRepository.findOne(user.getUserId());
        System.out.println("current logged " + one);
        return one;
    }

    @Override
    public User changeUserRole(long userId, Role role) {
        User user = userRepository.findOne(userId);
        user.setRole(role);
        return userRepository.save(user);
    }

    @Override
    public User updateUserById(long userId, User userData) {
        User user = userRepository.findOne(userId);
        user.setFirstName(userData.getFirstName());
        user.setLastName(userData.getLastName());
        user.setPhoneNumber(userData.getPhoneNumber());
        System.out.println("loaded user " + user);
        Address addressData = userData.getAddresses();
        Address address = user.getAddresses();
        if(address == null){
            address = new Address(addressData.getStreet(), addressData.getHouseNumber(), addressData.getCity(), addressData.getZipCode());
            System.out.println("nowy");
            System.out.println(address);
            address.setUserId(user.getUserId());
//            address = addressRepository.save(address);
//            user.setAddresses(address);
        }else{
            System.out.println("update");
            System.out.println(address);
            address.setCity(addressData.getCity());
            address.setHouseNumber(addressData.getHouseNumber());
            address.setStreet(addressData.getStreet());
            address.setZipCode(addressData.getZipCode());
//            address = addressRepository.save(address);
        }
        user.setAddresses(address);
        System.out.println(user);
        User temp = userRepository.save(user);
        System.out.println(temp);
        System.out.println("findOne " + userRepository.findOne(temp.getUserId()));
        return temp;
    }

    @Override
    public User setAddress(long userId, Address address) {
        User user = userRepository.findOne(userId);
        user.setAddresses(address);
        return userRepository.save(user);
    }

}
