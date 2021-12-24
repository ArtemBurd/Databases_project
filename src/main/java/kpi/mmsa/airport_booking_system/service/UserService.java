package kpi.mmsa.airport_booking_system.service;

import kpi.mmsa.airport_booking_system.model.User;
import kpi.mmsa.airport_booking_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserByPassNo(String passNo){
        Optional<User> user = userRepository.findBypassNo(passNo);
        if (user.isEmpty()) { throw new IllegalArgumentException("User with this passport number is not found"); }
        return user.get();
    }

    public User saveUser(User newUser){
        return userRepository.save(newUser);
    }

    public User updateUser(String passNo, User updatedUser){
        Optional<User> user = userRepository.findBypassNo(passNo);
        if (user.isEmpty()) { throw new IllegalArgumentException("User with this passport number is not found"); }
        User oldUser = user.get();
        oldUser.setName(updatedUser.getName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setBirth(updatedUser.getBirth());
        oldUser.setExpiry(updatedUser.getExpiry());
        oldUser.setNationality(updatedUser.getNationality());
        oldUser.setPhone(updatedUser.getPhone());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setPassword(updatedUser.getPassword());
        oldUser.setRole(updatedUser.getRole());
        oldUser.setStatus(updatedUser.getStatus());
        return userRepository.save(oldUser);
    }

    public User changeUserPassNo(String passNo, User updatedUser) {
        Optional<User> user = userRepository.findBypassNo(passNo);
        if (user.isEmpty()) { throw new IllegalArgumentException("User with this passport number is not found"); }

        userRepository.deleteById(passNo);
        return userRepository.save(updatedUser);
    }

    public String deleteUserByPassNo(String passNo) {
        userRepository.deleteById(passNo);
        return "User was successfully deleted";
    }

}
