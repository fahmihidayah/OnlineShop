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
        //TODO: add validation if userName and mail exist
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
        return userRepository.findByUserName(userName);
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
//        if(userData.getFirstName()!=null)
        user.setFirstName(userData.getFirstName());
//        if(userData.getLastName()!=null)
        user.setLastName(userData.getLastName());
//        if(userData.getPhoneNumber()!=null)
        user.setPhoneNumber(userData.getPhoneNumber());
        user.setAddresses(userData.getAddresses());
        return userRepository.save(user);
    }

    @Override
    public User setAddress(long userId, Address address) {
        User user = userRepository.findOne(userId);
        user.setAddresses(address);
        return userRepository.save(user);
    }

}
