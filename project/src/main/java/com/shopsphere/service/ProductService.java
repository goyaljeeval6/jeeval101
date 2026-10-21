package com.shopsphere.service;
import com.shopsphere.dao.ProductDAO; import com.shopsphere.model.Product; import java.util.List;
public class ProductService {
 private final ProductDAO dao=new ProductDAO();
 public List<Product> search(String q)throws Exception{return dao.findAll(q);}
 public Product find(int id)throws Exception{return dao.findById(id);}
 public void create(Product p)throws Exception {if(p.getName()==null||p.getName().isBlank()||p.getPrice()==null||p.getPrice().signum()<=0||p.getDiscount()==null||p.getDiscount().signum()<0||p.getDiscount().compareTo(new java.math.BigDecimal("100"))>0||p.getStock()<0)throw new IllegalArgumentException("Check product name, price, discount, and stock.");dao.save(p);}
 public void remove(int id)throws Exception{dao.delete(id);}
}
