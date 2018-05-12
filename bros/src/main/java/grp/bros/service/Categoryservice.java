package grp.bros.service;

import java.util.List;

import grp.bros.model.Category;

public interface Categoryservice {
	
	public void addcategory(Category c);
	public void updatecategory(Category cate);
public void displaycategory();
public List<Category> getCat();
public List<Category> getCatname();
public List<Category> getCategoryById(String cid);
}
