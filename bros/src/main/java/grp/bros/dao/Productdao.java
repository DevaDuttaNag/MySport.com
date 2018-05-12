package grp.bros.dao;

import java.util.List;

import grp.bros.model.Products;

public interface Productdao {

public List<Products> getProducts();


public void addproduct(Products pd);
public List<Products> getProductsById(String uid);


public void updproduct(Products p);
}
