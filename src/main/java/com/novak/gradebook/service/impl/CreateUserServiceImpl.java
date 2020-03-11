/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.service.impl;

import com.novak.gradebook.entity.User;
import com.novak.gradebook.repository.UserRepository;
import com.novak.gradebook.repository.impl.UserRepositoryImpl;
import com.novak.gradebook.service.CreateUserService;
import com.novak.gradebook.util.PasswordUtil;
import java.security.NoSuchAlgorithmException;
import org.apache.log4j.Logger;


/**
 *
 * @author rnovak
 */
public class CreateUserServiceImpl implements CreateUserService {

    private Logger logger = Logger.getLogger(CreateUserServiceImpl.class);

    @Override
    public String createUser(User user) {
        String message = null;
        if (!userExists(user.getId())) {
            UserRepository userRepository = new UserRepositoryImpl();
            user.setSalt(PasswordUtil.generateSalt());
            user.setRole("TEACHER");
            String saltedHash = null;
            try {
                saltedHash = PasswordUtil.hashPassword(user.getPassword() + user.getSalt());
            } catch (NoSuchAlgorithmException ex) {
                logger.error(ex);
            }
            user.setPassword(saltedHash);
            userRepository.save(user);
            message = "Account created.";
            logger.info("account created.");
        } else {
            message = "User already exists.";
            logger.info("user exists.");
        }
        return message;
    }

    /**
     * Checks if a user currently exists
     *
     * @param id the user id
     * @return true if exists otherwise false
     */
    private boolean userExists(String id) {
        boolean exists = false;
        UserRepository userRepository = new UserRepositoryImpl();
        User user = userRepository.findById(id);
        if (user != null) {
            exists = true;
        }
        return exists;
    }

}
