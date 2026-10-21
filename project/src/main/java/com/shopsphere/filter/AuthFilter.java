package com.shopsphere.filter;
import jakarta.servlet.*; import jakarta.servlet.annotation.WebFilter; import jakarta.servlet.http.*; import java.io.IOException;
@WebFilter(urlPatterns={"/cart","/checkout","/orders","/wishlist"})
public class AuthFilter implements Filter {
 public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{HttpServletRequest q=(HttpServletRequest)req;HttpServletResponse r=(HttpServletResponse)res;if(q.getSession(false)==null||q.getSession(false).getAttribute("user")==null){r.sendRedirect(q.getContextPath()+"/login");return;}chain.doFilter(req,res);}
}
