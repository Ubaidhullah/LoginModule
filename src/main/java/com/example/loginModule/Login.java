package com.example.loginModule;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uname= request.getParameter("uname");
    String pass= request.getParameter("pass");
        LoginDao dao = new LoginDao();

        if (dao.check(uname, pass)){
        HttpSession session= request.getSession();
        session.setAttribute("username", uname);
        response.sendRedirect("welcome.jsp");
    }
    else{
        response.sendRedirect("login.jsp");
    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
