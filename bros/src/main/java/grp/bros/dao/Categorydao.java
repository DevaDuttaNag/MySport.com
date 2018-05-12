package grp.bros.dao;

import java.util.List;

import grp.bros.model.Category;

public interface Categorydao {

	public void addcategory(Category c);

	public List<Category> getCat();

	public List<Category> getCatname();

	public List<Category> getCategoryById(String cid);

	public void updateCategory(Category cate);

}
