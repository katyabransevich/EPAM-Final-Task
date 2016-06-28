package by.epam.finaltask.facultative.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerLocal extends HttpServlet {
    private static final String LOCAL = "local";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true).setAttribute(LOCAL, request.getParameter(LOCAL));
        request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);

    }

}
