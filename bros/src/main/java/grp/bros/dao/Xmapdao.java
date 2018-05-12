package grp.bros.dao;

import java.util.List;

import grp.bros.model.Category;
import grp.bros.model.Procatsup;
import grp.bros.model.Products;
import grp.bros.model.Supplier;
import grp.bros.model.UserData;

public interface Xmapdao {

	public List<Procatsup> getXData();

	public List<Products> getAPid();

	public List<Supplier> getASupid();

	public List<Category> getACatid();

	public boolean addXdata(Procatsup xpcs);

	public List<Procatsup> getXDataById(String xid);

	public void updateXData(Procatsup xpcs);

	public List<UserData> getUserData();
	public UserData getUserDataById(String xid);
	
}
