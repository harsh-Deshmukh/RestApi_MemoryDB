package com.uxpsystems.assignment.service;

import com.uxpsystems.assignment.config.AppRootConfig;
import com.uxpsystems.assignment.controller.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppRootConfig.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @BeforeClass
    public static void init() {

    }

    @Test
    public void createUser() {

        int i = userService.createUser(new User("Harshal", "Alyx", "Active"));
        Assert.assertEquals(i, 3);
    }

    @Test
    public void getAllUser() {
        userService.createUser(new User("Harshal", "Alyx", "Active"));
        List<User> user = userService.getAllUser();
        Assert.assertEquals(user.size(), 2);
    }

    @Test
    public void deleteUser(){
        User user=new User("Harshal", "Alyx", "Active");
        userService.createUser(user);
        Assert.assertEquals(userService.getAllUser().size(),4);
        int id=userService.deleteUser(user);
        Assert.assertNotNull(userService.getAllUser().isEmpty());
        Assert.assertEquals(id,4);
    }

    @Test
    public void updateUser(){
        User user=new User("Harshal", "Alyx", "Active");
        int id=userService.createUser(user);
        user.setUserName("Bakish");
        user.setStatus("Active");
        user.setPassword("Amdocs");
        user.setId(id);
       User updateUser=userService.updateUser(user);
       Assert.assertEquals(user.getId(),updateUser.getId());
       Assert.assertEquals(user.getUserName(),updateUser.getUserName());
        Assert.assertEquals(user.getPassword(),updateUser.getPassword());
    }
}

