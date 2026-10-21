package com.shopsphere.service;
import com.shopsphere.dao.UserDAO; import com.shopsphere.model.User; import org.mindrot.jbcrypt.BCrypt;
public class AuthService {
 private final UserDAO dao=new UserDAO();
 public void register(String name,String email,String password,String mobile)throws Exception {
  if(name==null||name.isBlank()||email==null||!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")||password==null||password.length()<8) throw new IllegalArgumentException("Enter a valid name/email and a password of at least 8 characters.");
  if(dao.emailExists(email.trim().toLowerCase())) throw new IllegalArgumentException("An account with this email already exists.");
  dao.create(name.trim(),email.trim().toLowerCase(),BCrypt.hashpw(password,BCrypt.gensalt()),mobile==null?"":mobile.trim());
 }
 public User login(String email,String password)throws Exception {String normalized=email==null?"":email.trim().toLowerCase();String hash=dao.passwordHash(normalized);if(hash==null||password==null||!BCrypt.checkpw(password,hash))return null;return dao.findByEmail(normalized);}
}
