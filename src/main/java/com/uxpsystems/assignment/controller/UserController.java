package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static Logger logger= Logger.getLogger("UserController.class");
    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createUser(@RequestBody User user) {
        logger.debug("Popst method....");
        int id = userService.createUser(user);
        return new ResponseEntity<String>("User with User ID :" + id + " created successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> getAllUser() {
        List<User> list = userService.getAllUser();
        return new ResponseEntity<List<User>>(list, HttpStatus.OK);
    }

    @PutMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<User>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletUserByID(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("User with User Id :" + id + " deleted..", HttpStatus.OK);
    }
    @DeleteMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletUser(@RequestBody User user) {
        int id=userService.deleteUser(user);
        return new ResponseEntity<String>("User with User Id :" + id + " deleted..", HttpStatus.OK);
    }
}
