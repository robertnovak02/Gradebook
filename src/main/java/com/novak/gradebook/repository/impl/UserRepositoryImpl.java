/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.repository.impl;

import com.novak.gradebook.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.novak.gradebook.repository.UserRepository;
import org.apache.log4j.Logger;

/**
 * This implementation provides functionality for persisting User data
 *
 * @author rnovak
 */
public class UserRepositoryImpl implements UserRepository {

    private Logger logger = Logger.getLogger(UserRepositoryImpl.class);

    @Override
    public User findById(String id) {
        User user = null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Gradebook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            user = entityManager.find(User.class, id);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Error occurred while saving user.", e);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        boolean success = false;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Gradebook");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            logger.error("Error occurred while saving user.", e);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return success;
    }

    @Override
    public boolean update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
