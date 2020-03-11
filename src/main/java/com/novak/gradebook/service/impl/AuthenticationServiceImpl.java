/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.service.impl;

import com.novak.gradebook.entity.User;
import com.novak.gradebook.model.Auth;
import com.novak.gradebook.repository.UserRepository;
import com.novak.gradebook.repository.impl.UserRepositoryImpl;
import com.novak.gradebook.service.AuthenticationService;
import com.novak.gradebook.util.PasswordUtil;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rnovak
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Auth authenticate(String userName, char[] password) {
        Auth auth = new Auth();
        UserRepository userRepository = new UserRepositoryImpl();
        User user = userRepository.findById(userName);
        if (user != null) {
            auth = authenticateUser(user, password);
        }

        return auth;
    }

    private Auth authenticateUser(User user, char[] password) {
        String pass = null;
        Auth auth = new Auth();
        auth.setAuthenticated(true);
        try {
            pass = String.valueOf(password);
            if (user.getPassword().equals(PasswordUtil.hashPassword(pass + user.getSalt()))) {
                auth.setAuthenticated(true);
                auth.setUserName(user.getId());
                auth.setRoles(new String[]{"TEACHER"});
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthenticationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return auth;
    }

}
