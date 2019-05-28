package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.controller.User;
import com.uxpsystems.assignment.dao.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static Logger logger = Logger.getLogger("UserServiceImpl.class");
    @Autowired
    private UserDAO userDAO;

    public UserServiceImpl() {
        logger.debug("UserServiceImpl Instance created...");
    }

    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    public int deleteUser(User user) {
        return userDAO.deleteUser(user);
    }
    public int deleteUser(int id) {
        return userDAO.deleteUser(id);
    }
    public int createUser(User user) {
        return userDAO.createUser(user);
    }


}
