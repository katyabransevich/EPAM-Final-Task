package by.epam.finaltask.facultative.controller;

import by.epam.finaltask.facultative.command.Command;
import by.epam.finaltask.facultative.command.exception.CommandException;
import by.epam.finaltask.facultative.controller.helper.*;
import by.epam.finaltask.facultative.dao.connectionpool.ConnectionPool;
import by.epam.finaltask.facultative.dao.exception.ConnectionPoolException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
        private static final long serialVersionUID = 1L;

        private static final String COMMAND_NAME = "command";

        private final CommandHelp commandHelper = new CommandHelp();




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward(request,  response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward(request,  response);

    }

    protected void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = null;
        Command command = null;
        String page = null;
        try{
            commandName = request.getParameter(COMMAND_NAME);
            command = commandHelper.getCommand(commandName);
            page = command.execute(request);
        }catch(CommandException e){
            page = PageName.ERROR_PAGE;
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null){
            dispatcher.forward(request, response);
        }

    }



}
