package com.shopsphere.controller;
import com.shopsphere.model.Product; import com.shopsphere.service.ProductService; import jakarta.servlet.annotation.WebServlet; import jakarta.servlet.http.*; import jakarta.servlet.ServletException; import java.io.IOException; import java.math.BigDecimal;
@WebServlet("/admin/products")
public class AdminProductServlet extends HttpServlet {
 private final ProductService service=new ProductService();
 protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{try{q.setAttribute("products",service.search(""));q.getRequestDispatcher("/WEB-INF/views/admin-products.jsp").forward(q,r);}catch(Exception e){throw new ServletException(e);}}
 protected void doPost(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{try{String action=q.getParameter("action");if("delete".equals(action)){service.remove(Integer.parseInt(q.getParameter("id")));}else{Product p=new Product();p.setCategoryId(Integer.parseInt(q.getParameter("categoryId")));p.setName(q.getParameter("name"));p.setBrand(q.getParameter("brand"));p.setDescription(q.getParameter("description"));p.setPrice(new BigDecimal(q.getParameter("price")));p.setDiscount(new BigDecimal(q.getParameter("discount")));p.setStock(Integer.parseInt(q.getParameter("stock")));p.setImageUrl(q.getParameter("imageUrl"));service.create(p);}r.sendRedirect(q.getContextPath()+"/admin/products");}catch(Exception e){q.setAttribute("error","Could not save product. Check the values and database.");doGet(q,r);}}
}
