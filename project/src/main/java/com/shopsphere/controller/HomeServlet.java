package com.shopsphere.controller;
import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import jakarta.servlet.ServletException; import java.io.IOException;
@WebServlet("/")
public class HomeServlet extends HttpServlet {protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{q.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(q,r);}}
