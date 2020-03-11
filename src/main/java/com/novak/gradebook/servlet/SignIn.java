/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.servlet;

import com.novak.gradebook.model.Auth;
import com.novak.gradebook.service.AuthenticationService;
import com.novak.gradebook.service.impl.AuthenticationServiceImpl;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author rnovak
 */
public class SignIn extends HttpServlet {

    private Logger logger = Logger.getLogger(SignIn.class);

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("testing");
        RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/signIn.jsp");
        requestDispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        AuthenticationService authenticationService = new AuthenticationServiceImpl();
        Auth auth = authenticationService.authenticate(userName, password.toCharArray());
        if (auth.isAuthenticated()) {
            logger.debug("Authenticated");

//            request.setAttribute("name", auth.getUserName());
            request.getSession().setAttribute("name", auth.getUserName());
            request.getSession().setAttribute("authenticated", Boolean.TRUE);
            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            requestDispatcher.forward(request, response);
        } else {

        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
