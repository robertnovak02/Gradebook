/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.model;

/**
 * POJO that contains authentication user data
 * @author rnovak
 */
public class Auth {
    private String userName;
    private String[] roles;
    private boolean authenticated;
    
    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String[] getRoles() {
        return roles;
    }

    /**
     *
     * @param roles
     */
    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    /**
     *
     * @return
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     *
     * @param authenticated
     */
    public void setAuthenticated(boolean authenticated){
        this.authenticated = authenticated;
    }
}
