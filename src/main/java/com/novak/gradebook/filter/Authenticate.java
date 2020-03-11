/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.novak.gradebook.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 * Check if the request was submitted by an already authenticated user
 *
 * @author rnovak
 */
public class Authenticate implements Filter {

    Logger logger = Logger.getLogger(Authenticate.class);
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public Authenticate() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String servletPath = httpServletRequest.getServletPath();
        HttpSession httpSession = httpServletRequest.getSession();
        Boolean isAuthenticated = (Boolean) httpSession.getAttribute("authenticated");
        logger.info("Authenticated? " + isAuthenticated);
        logger.debug("is authenticated? " + isAuthenticated);
        logger.info("Servlet Path: " + servletPath);
        if (servletPath.startsWith("/resources/") || servletPath.startsWith("/SignIn")) {
            logger.info("It's a resource");
            chain.doFilter(request, response);
        } else if (null == isAuthenticated || !isAuthenticated) {
            logger.info("no session, redirecting to sign in.");
            request.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp").forward(request, response);
        } else {
            logger.info("Forwarding to home.jsp");
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        }
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
        filterConfig = null;
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("Authenticate:Initializing filter");
            }
        }
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
