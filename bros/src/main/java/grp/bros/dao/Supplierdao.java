package grp.bros.dao;

import java.util.List;

import grp.bros.model.Supplier;

public interface Supplierdao {

	public void modifySupp();
	public List<Supplier> getSupp();
	public void addSupp(Supplier s);
	public void delSupp(Supplier s);
	public void updateSupplier(Supplier sup);
	public List<Supplier> getSupplierById(String sid);
}
