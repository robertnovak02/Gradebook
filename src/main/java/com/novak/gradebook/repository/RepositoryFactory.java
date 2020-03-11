/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.repository;

/**
 * Creates repository instances
 *
 * @author rnovak
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;

    public static RepositoryFactory getInstance() {
        if (instance == null) {
            synchronized (RepositoryFactory.class) {
                if (instance == null) {
                    instance = new RepositoryFactory();
                }
            }

        }
        return instance;
    }

}
