package com.uxpsystems.assignment.dao;

import com.uxpsystems.assignment.controller.User;

import java.util.List;

public interface UserDAO {
    public User updateUser(User user);
    public List<User> getAllUser();
    public int deleteUser(User user);
    public int deleteUser(int id);
    public int createUser(User user);
}
