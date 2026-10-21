package com.shopsphere.controller;
import com.shopsphere.service.ProductService; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import jakarta.servlet.ServletException; import java.io.IOException;
@WebServlet("/product")
public class ProductDetailsServlet extends HttpServlet {
 private final ProductService service=new ProductService();
 protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{try{int id=Integer.parseInt(q.getParameter("id"));var p=service.find(id);if(p==null){r.sendError(404);return;}q.setAttribute("product",p);q.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(q,r);}catch(NumberFormatException e){r.sendError(400);}catch(Exception e){throw new ServletException(e);}}
}
