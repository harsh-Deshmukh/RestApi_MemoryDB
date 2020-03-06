package com.uxpsystems.assignment;

import com.uxpsystems.assignment.config.AppRootConfig;
import com.uxpsystems.assignment.controller.User;
import com.uxpsystems.assignment.dao.UserDAO;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppRootConfig.class)

public class UserDAOImplTest {
    @Autowired
    UserDAO userDAO;

    @BeforeClass
    public static void init() {

    }

    @Test
    public void createUser() {
        int i = userDAO.createUser(new User("Harshal", "Alyx", "Active"));
    }

    @Test
    public void getAllUser() {
        userDAO.createUser(new User("Harshal", "Alyx", "Active"));
        List<User> user = userDAO.getAllUser();

    }

    @Test
    public void deleteUser() {
        User user = new User("Harshal", "Alyx", "Active");
        userDAO.createUser(user);
        int id = userDAO.deleteUser(user);

    }

    @Test
    public void updateUser() {
        User user = new User("Harshal", "Alyx", "Active");
        int id = userDAO.createUser(user);
        user.setUserName("Bakish");
        user.setStatus("Active");
        user.setPassword("Amdocs");
        user.setId(id);
        User updateUser = userDAO.updateUser(user);
        Assert.assertEquals(user.getId(), updateUser.getId());
        Assert.assertEquals(user.getUserName(), updateUser.getUserName());
        Assert.assertEquals(user.getPassword(), updateUser.getPassword());
    }

}
