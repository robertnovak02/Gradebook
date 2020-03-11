/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.service;

import com.novak.gradebook.model.Auth;

/**
 * Provides functionality for authenticating a user
 *
 * @author rnovak
 */
public interface AuthenticationService {

    /**
     * Authenticates a user
     *
     * @param userName the userName
     * @param password the password
     * @return the Auth object
     */
    public Auth authenticate(String userName, char[] password);
}
