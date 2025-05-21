package com.example.mvc_crud;

import com.example.mvc_crud.entities.user;
import com.example.mvc_crud.model.dbconnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "userServlet", urlPatterns = "/users/*")
public class userServlet extends HttpServlet {
    private List<user> listUser;
    @Override
    public void init() throws ServletException {
        this.listUser = new ArrayList<>();
        user u1 = new user(1, "Nam", "nam@gmail.com", "nam123", "0123456789", "123 Ha Noi");
        listUser.add(u1);
        user u2 = new user(2, "quan", "quan@gmail.com", "quan123", "0123456789", "123 Ha Noi");
        listUser.add(u2);
        user u3 = new user(3, "duy", "duy@gmail.com", "duy123", "0123456789", "123 Ha Noi");
        listUser.add(u3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getPathInfo();
        System.out.println(uri);
        if (uri == null) {
            uri = "";
        }

        switch (uri) {
            case "/create":
                renderPageCreateUser(request, response);
                break;
            case "/delete":
                deleteUSer(request, response);
                break;
            case "/update":
                renderPageUpdateUser(request, response);
                break;
            default:
                renderPageListUser(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getPathInfo();
        if (uri == null) {
            uri = "";
        }

        switch (uri) {
            case "/create":
                createUser(request, response);
                break;
            case "/update":
                updateUser(request, response);
                break;
        }
    }

    public void renderPageListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // call jsp servlet with url like bellow:
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/list.jsp");
        dispatcher.forward(request, response);
    }

    public void deleteUSer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // take id from url
        int id = Integer.parseInt(request.getParameter("id"));
        user userRemove = getUserByID(id);
        listUser.remove(userRemove);
        response.sendRedirect("/users");
    }

    private user getUserByID(int id) {
        user userRemove = null;
        for (user item :listUser) {
            if (item.getId() == id) {
                userRemove = item;
                break;
            }
        }
        return userRemove;
    }

    public void renderPageCreateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/create.jsp");
        dispatcher.forward(request, response);
    }

    public void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // take date from request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int maxID = listUser.size() - 1;
        user user = new user(maxID + 1, name, email, password);
        listUser.add(user);
        response.sendRedirect("/users");
    }

    public void renderPageUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // take user data by id
        int id = Integer.parseInt(request.getParameter("id"));
        user userUpdate = getUserByID(id);

        request.setAttribute("userUpdate", userUpdate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/users/update.jsp");
        dispatcher.forward(request,response);
    }
    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        user userUpdate = getUserByID(id);
        String name = request.getParameter("name");
        userUpdate.setName(name);
        response.sendRedirect("/users");
    }
}
