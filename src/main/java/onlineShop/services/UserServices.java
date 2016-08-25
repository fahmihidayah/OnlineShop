package onlineShop.services;

import onlineShop.dao.UserRepository;
import onlineShop.domain.Address;
import onlineShop.domain.Role;
import onlineShop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Damian Bartos
 * 23.08.2016.
 */
@Service
public class UserServices {
    @Autowired
    UserRepository userRepository;

    public User registerUser(String login, String hashedPassword, String email, Role role){
        User newUser = new User(login, hashedPassword, email);
        newUser.setRole(role);
        return userRepository.save(newUser);
    }

    public User updateNames(Integer userId, String firstName, String lastName){
        User user = userRepository.findOne(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return userRepository.save(user);
    }

    public User updatePhoneNumber(Integer userId, String phoneNumber){
        User user = userRepository.findOne(userId);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    public User addAddress(Integer userId, Address address){
        User user = userRepository.findOne(userId);
        user.getAddresses().add(address);
        return userRepository.save(user);
    }

    public boolean checkPassword(Integer userId, String hashedPassword){
        User user = userRepository.findOne(userId);
        return hashedPassword.equals(user.getHashedPassword());
    }

    public User getUserById(int userId){
        return userRepository.findOne(userId);
    }

}
