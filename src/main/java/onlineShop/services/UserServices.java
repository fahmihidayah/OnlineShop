package onlineShop.services;

import onlineShop.dao.UserRepository;
import onlineShop.domain.Address;
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

    public void registerUser(String login, String hashedPassword, String email){
        User newUser = new User(login, hashedPassword, email);
        saveUserToRepository(newUser);
    }

    public void setNames(Integer userId, String firstName, String lastName){
        User user = getUserFromRepository(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        saveUserToRepository(user);
    }

    public void setPhoneNumber(Integer userId, String phoneNumber){
        User user = getUserFromRepository(userId);
        user.setPhoneNumber(phoneNumber);
        saveUserToRepository(user);
    }

    public void addAddress(Integer userId, Address address){
        User user = getUserFromRepository(userId);
        user.getAddresses().add(address);
        saveUserToRepository(user);
    }

    public boolean checkPassword(Integer userId, String hashedPassword){
        User user = getUserFromRepository(userId);
        return hashedPassword.equals(user.getHashedPassword());
    }

    private User getUserFromRepository(Integer userId) {
        return userRepository.findOne(userId);
    }

    private void saveUserToRepository(User user) {
        userRepository.save(user);
    }
}
