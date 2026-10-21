package com.shopsphere.dao;
import com.shopsphere.model.Product; import com.shopsphere.util.DB;
import java.sql.*; import java.util.*;
public class ProductDAO {
 private Product map(ResultSet r)throws SQLException { Product p=new Product(); p.setProductId(r.getInt("product_id")); p.setCategoryId(r.getInt("category_id")); p.setName(r.getString("name")); p.setBrand(r.getString("brand")); p.setDescription(r.getString("description")); p.setPrice(r.getBigDecimal("price")); p.setDiscount(r.getBigDecimal("discount")); p.setStock(r.getInt("stock")); p.setImageUrl(r.getString("image_url")); return p; }
 public List<Product> findAll(String q)throws SQLException {
  String sql="SELECT * FROM products WHERE status=1 AND (?='' OR name LIKE ? OR brand LIKE ?) ORDER BY created_at DESC";
  List<Product> out=new ArrayList<>(); try(Connection c=DB.getConnection(); PreparedStatement s=c.prepareStatement(sql)){String term=q==null?"":q.trim(); s.setString(1,term); s.setString(2,"%"+term+"%"); s.setString(3,"%"+term+"%"); try(ResultSet r=s.executeQuery()){while(r.next())out.add(map(r));}} return out;
 }
 public Product findById(int id)throws SQLException { try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement("SELECT * FROM products WHERE product_id=? AND status=1")){s.setInt(1,id);try(ResultSet r=s.executeQuery()){return r.next()?map(r):null;}}}
 public void save(Product p)throws SQLException {String sql="INSERT INTO products(category_id,name,brand,description,price,discount,stock,image_url) VALUES(?,?,?,?,?,?,?,?)";try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement(sql)){s.setInt(1,p.getCategoryId());s.setString(2,p.getName());s.setString(3,p.getBrand());s.setString(4,p.getDescription());s.setBigDecimal(5,p.getPrice());s.setBigDecimal(6,p.getDiscount());s.setInt(7,p.getStock());s.setString(8,p.getImageUrl());s.executeUpdate();}}
 public void delete(int id)throws SQLException {try(Connection c=DB.getConnection();PreparedStatement s=c.prepareStatement("UPDATE products SET status=0 WHERE product_id=?")){s.setInt(1,id);s.executeUpdate();}}
}
