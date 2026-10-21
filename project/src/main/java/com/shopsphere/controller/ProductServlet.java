package com.shopsphere.controller;
import com.shopsphere.service.ProductService; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import jakarta.servlet.ServletException; import java.io.IOException;
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
 private final ProductService service=new ProductService();
 protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{try{q.setAttribute("products",service.search(q.getParameter("q")));q.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(q,r);}catch(Exception e){throw new ServletException("Unable to load products. Check database setup.",e);}}
}
