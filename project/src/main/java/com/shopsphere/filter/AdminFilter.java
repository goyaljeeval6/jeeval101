package com.shopsphere.filter;
import com.shopsphere.model.User; import jakarta.servlet.*; import jakarta.servlet.annotation.WebFilter; import jakarta.servlet.http.*; import java.io.IOException;
@WebFilter(urlPatterns={"/admin/*"})
public class AdminFilter implements Filter {
 public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException,ServletException{HttpServletRequest q=(HttpServletRequest)req;HttpServletResponse r=(HttpServletResponse)res;Object o=q.getSession(false)==null?null:q.getSession(false).getAttribute("user");if(!(o instanceof User u)||!"ADMIN".equals(u.getRole())){r.sendError(HttpServletResponse.SC_FORBIDDEN,"Admin access required.");return;}chain.doFilter(req,res);}
}
