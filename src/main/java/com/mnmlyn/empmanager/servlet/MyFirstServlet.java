package com.mnmlyn.empmanager.servlet;

import com.mnmlyn.empmanager.DAO.impl.EmpDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFirstServlet extends HttpServlet {
    public MyFirstServlet() {
        System.out.println("servlet init");
    }

    @Autowired
    private EmpDAOImpl empDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------enter servlet-------------");
        // uri = contextPath + servletPath + others
        String uri = req.getRequestURI();
        uri = uri.substring(req.getContextPath().length() + req.getServletPath().length());
        if (uri.length() > 0 && uri.substring(0, 1).equals("/")) {
            uri = uri.substring(1);
        }
        System.out.println("uri=" + uri);

        String dispatchPath;
        if ("first".equals(uri)) {
            dispatchPath = "/WEB-INF/jsp/first.jsp";
            req.setAttribute("emp", empDAO.queryEmp());
        } else {
            dispatchPath = "/index.jsp";
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchPath);
        dispatcher.forward(req, resp);

        System.out.println("++++++++++exit servlet+++++++++++++");
    }
}
