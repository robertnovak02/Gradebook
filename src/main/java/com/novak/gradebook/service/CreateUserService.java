/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.service;

import com.novak.gradebook.entity.User;

/**
 * Provides functionality for creating a new user
 * @author rnovak
 */
public interface CreateUserService {
    /**
     * Creates a new user
     * @param user the user to create
     * @return response the create user response
     */
    public String createUser(User user);
}
