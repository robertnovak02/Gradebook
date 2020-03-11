/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.novak.gradebook.entity.User;
import com.novak.gradebook.service.CreateUserService;
import com.novak.gradebook.service.impl.CreateUserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * Servlet used to handle requests sent to CreateAccount
 *
 * @author rnovak
 */
public class CreateAccount extends HttpServlet {

    private Logger logger = Logger.getLogger(CreateAccount.class);

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
        response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/createAccount.jsp");
        dispatcher.forward(request, response);
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
        System.out.println(request.getParameter("email"));
        User user = new User();
        user.setId(request.getParameter("username"));
        LocalDateTime now = LocalDateTime.now();
        user.setChangeDate(now);
        user.setCreateDate(now);
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        CreateUserService createUserService = new CreateUserServiceImpl();
        String message = createUserService.createUser(user);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        ObjectMapper mapper = new ObjectMapper();
        String jsonResult = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        System.out.println(jsonResult);
        logger.info("Response: " + jsonResult);
        out.write(jsonResult);
        out.flush();

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
