package com.shopsphere.controller;
import com.shopsphere.model.User; import com.shopsphere.service.AuthService; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import jakarta.servlet.ServletException; import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 private final AuthService auth=new AuthService();
 protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{q.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(q,r);}
 protected void doPost(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{try{User u=auth.login(q.getParameter("email"),q.getParameter("password"));if(u==null){q.setAttribute("error","Email or password is incorrect.");q.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(q,r);return;}q.getSession(true).setAttribute("user",u);r.sendRedirect(q.getContextPath()+("/ADMIN".equals(u.getRole())?"/admin/products":"/products"));}catch(Exception e){throw new ServletException("Login failed. Check database configuration.",e);}}
}
