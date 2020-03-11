<%-- 
    Document   : nav
    Created on : Mar 2, 2020, 8:54:05 PM
    Author     : rnovak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="bg-light border-right" id="sidebar-wrapper">
    <div class="sidebar-heading">Gradebook </div>
    <div class="list-group list-group-flush">
        <a href="#" class="list-group-item list-group-item-action bg-light ${selectedNav}">Dashboard</a>
        <a href="#" class="list-group-item list-group-item-action bg-light ${selectedNav}">Assignments</a>
        <a href="Students" class="list-group-item list-group-item-action bg-light ${selectedNav}">Students</a>
        <a href="#" class="list-group-item list-group-item-action bg-light ${selectedNav}">Events</a>
        <a href="#" class="list-group-item list-group-item-action bg-light ${selectedNav}">Profile</a>
        <a href="#" class="list-group-item list-group-item-action bg-light ${selectedNav}">Status</a>
    </div>
</div>
