package com.shopsphere.controller;
import com.shopsphere.service.AuthService; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import jakarta.servlet.ServletException; import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
 private final AuthService auth=new AuthService();
 protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{q.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(q,r);}
 protected void doPost(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{try{auth.register(q.getParameter("name"),q.getParameter("email"),q.getParameter("password"),q.getParameter("mobile"));r.sendRedirect(q.getContextPath()+"/login?registered=1");}catch(IllegalArgumentException e){q.setAttribute("error",e.getMessage());q.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(q,r);}catch(Exception e){throw new ServletException("Registration failed. Check database configuration.",e);}}
}
