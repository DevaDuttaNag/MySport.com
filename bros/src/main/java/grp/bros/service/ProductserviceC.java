package grp.bros.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import grp.bros.dao.Productdao;
import grp.bros.model.Products;


@Service
public class ProductserviceC implements Productservice {
	
	@Autowired
	private Productdao pdao;
	
	

	public List<Products> getProducts() {
		List<Products> lst=pdao.getProducts();
	return lst;
	}


	public void addproduct(Products pd) {
		pdao.addproduct(pd);
	}


	public List<Products> getProductsByID(String uid) {
		System.out.println("prods service enter");

		List<Products> list= pdao.getProductsById(uid);
		System.out.println("prods service exit");

		return list;
	}


	public void updproduct(Products p) {
		pdao.updproduct(p);
		
	}


}
