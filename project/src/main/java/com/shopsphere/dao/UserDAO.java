package com.shopsphere.dao;
import com.shopsphere.model.User; import com.shopsphere.util.DB; import java.sql.*;
public class UserDAO {
 public boolean emailExists(String email)throws SQLException {try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement("SELECT user_id FROM users WHERE email=?")){s.setString(1,email);try(ResultSet r=s.executeQuery()){return r.next();}}}
 public void create(String name,String email,String hash,String mobile)throws SQLException {try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement("INSERT INTO users(name,email,password,mobile) VALUES(?,?,?,?)")){s.setString(1,name);s.setString(2,email);s.setString(3,hash);s.setString(4,mobile);s.executeUpdate();}}
 public User findByEmail(String email)throws SQLException {try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement("SELECT user_id,name,email,password,role,mobile FROM users WHERE email=? AND status=1")){s.setString(1,email);try(ResultSet r=s.executeQuery()){if(!r.next())return null; User u=new User();u.setUserId(r.getInt("user_id"));u.setName(r.getString("name"));u.setEmail(r.getString("email"));u.setRole(r.getString("role"));u.setMobile(r.getString("mobile"));return u;}}}
 public String passwordHash(String email)throws SQLException {try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement("SELECT password FROM users WHERE email=? AND status=1")){s.setString(1,email);try(ResultSet r=s.executeQuery()){return r.next()?r.getString(1):null;}}}
}
