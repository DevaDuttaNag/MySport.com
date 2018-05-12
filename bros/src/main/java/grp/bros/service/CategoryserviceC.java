package grp.bros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.bros.dao.Categorydao;
import grp.bros.model.Category;


@Service
public class CategoryserviceC implements Categoryservice {
@Autowired
private Categorydao cd;
	
	public void addcategory(Category c) {
		System.out.println(c.getCatname()+""+c.getCatid());
		cd.addcategory(c);
		
	}

	
	public void updatecategory(Category cate) {
		cd.updateCategory(cate);
	}

	
	public void displaycategory() {
		
	}


	public List<Category> getCat() {
		List<Category> l=cd.getCat();
		return l;
	}


	public List<Category> getCatname() {
		List<Category> lt=cd.getCatname();
		return lt;
	}


	public List<Category> getCategoryById(String cid) {
		List<Category> l=cd.getCategoryById(cid);
		return l;
	}

}
