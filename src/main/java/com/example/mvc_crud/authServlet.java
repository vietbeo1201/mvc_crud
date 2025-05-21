package com.example.mvc_crud;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet (name = "authServlet", urlPatterns = "/auth/*")
public class authServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // take uri from request ( behind /auth/ )
        String uri = request.getPathInfo();
        if (uri == null ){
            uri = "";
        }
        switch (uri){
            case "/login":

                renderPageLogin(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String uri = request.getPathInfo();
        if (uri == null ){
            uri = "";
        }
        switch (uri){
            case "/login":
                login(request, response);
                break;
        }
    }

    public void renderPageLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get jsp setvlet from url: /view/auth/login.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/auth/login.jsp");
        dispatcher.forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
         // take data from the form in login.jsp
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if ("viet@gmail.com".equals(email) && "123456".equals(password)) {
            response.sendRedirect("/hello");
        } else {
            response.sendRedirect("/auth/login");
        }
    }
}
