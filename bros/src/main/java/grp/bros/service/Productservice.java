package grp.bros.service;

import java.util.List;

import grp.bros.model.Login;
import grp.bros.model.Products;
import grp.bros.model.UserDetails;

public interface Productservice {

public List<Products> getProducts();
public void addproduct(Products pd);
public List<Products> getProductsByID(String uid);
public void updproduct(Products p);
}
