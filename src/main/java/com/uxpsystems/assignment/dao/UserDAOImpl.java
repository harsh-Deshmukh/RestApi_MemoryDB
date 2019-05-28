package com.uxpsystems.assignment.dao;

import com.uxpsystems.assignment.controller.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private static Logger logger = Logger.getLogger("UserDAOImpl.class");
    @Autowired
    SessionFactory sessionFactory;

    public UserDAOImpl() {
        logger.debug("UserDAOImpl instance created...");
    }

    public User updateUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", user.getId()));
        return (User) criteria.uniqueResult();
    }

    public List<User> getAllUser() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
        return criteria.list();
    }

    /*
    Use this way becoz if there is any foreign key  concept between table then by this way from both
    tables records gets deleted else by another way like firing delete query of using delete method
    it will possible through ConstraintViolation exceptn becoz of dependacy*/
    public int deleteUser(int id) {
        logger.debug("try to delete User with user ID:" + id);
        User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
            logger.debug("User with user ID:" + user + " deleted...");
        }
        return user.getId();
    }

    public int deleteUser(User user) {
        logger.debug("try to delete User with user ID:" + user);
        sessionFactory.getCurrentSession().delete(user);
        logger.debug("User with user ID:" + user + " deleted...");
        return user.getId();
    }

    public int createUser(User user) {
        Integer createdUSer = (Integer) sessionFactory.getCurrentSession().save(user);
        return createdUSer;
    }

}
