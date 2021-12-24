package kpi.mmsa.airport_booking_system.controller;

import kpi.mmsa.airport_booking_system.model.User;
import kpi.mmsa.airport_booking_system.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(value = "/user/{passNo}")
    public ResponseEntity<User> getUser(@PathVariable String passNo){
        return ResponseEntity.ok(userService.getUserByPassNo(passNo));
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> postUser(@Valid @RequestBody User newUser){
        return ResponseEntity.ok(userService.saveUser(newUser));
    }

    @PutMapping(value = "/user/{passNo}")
    public ResponseEntity<User> updateUser(@PathVariable String passNo, @Valid @RequestBody User updatedUser){
        return ResponseEntity.ok(userService.updateUser(passNo, updatedUser));
    }

    @PutMapping(value = "/user/change-passport-no/{passNo}")
    public ResponseEntity<User> changeUserPassNo(@PathVariable String passNo, @Valid @RequestBody User updatedUser){
        return ResponseEntity.ok(userService.changeUserPassNo(passNo, updatedUser));
    }

    @DeleteMapping(value = "/user/{passNo}")
    public ResponseEntity<String> deleteUser(@PathVariable String passNo) {
        return ResponseEntity.ok(userService.deleteUserByPassNo(passNo));
    }
}
