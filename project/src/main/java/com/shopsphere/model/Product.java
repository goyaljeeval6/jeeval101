package com.shopsphere.model;
import java.math.BigDecimal;
public class Product {
 private int productId, categoryId, stock; private String name, brand, description, imageUrl; private BigDecimal price, discount;
 public int getProductId(){return productId;} public void setProductId(int v){productId=v;}
 public int getCategoryId(){return categoryId;} public void setCategoryId(int v){categoryId=v;}
 public int getStock(){return stock;} public void setStock(int v){stock=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getBrand(){return brand;} public void setBrand(String v){brand=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
 public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal v){price=v;}
 public BigDecimal getDiscount(){return discount;} public void setDiscount(BigDecimal v){discount=v;}
 public BigDecimal getSalePrice(){return price.subtract(price.multiply(discount).divide(new BigDecimal("100"))); }
}
