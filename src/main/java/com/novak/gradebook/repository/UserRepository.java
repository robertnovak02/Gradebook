/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.repository;

import com.novak.gradebook.entity.User;

/**
 * Provides functionality for performing CRUD operations on the user table
 *
 * @author rnovak
 */
public interface UserRepository {

    /**
     * Find a user by id
     *
     * @param id the id
     * @return user if found otherwise null
     */
    public User findById(String id);

    /**
     * Save a user entity
     *
     * @param user the user
     * @return true is success
     */
    public boolean save(User user);

    /**
     * Updates a user entity
     *
     * @param user the user
     * @return true it success
     */
    public boolean update(User user);
}
