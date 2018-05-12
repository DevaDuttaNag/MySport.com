package grp.bros.service;

import java.util.List;

import grp.bros.model.Category;
import grp.bros.model.Supplier;

public interface Supplierservice {

	public void addSupp(Supplier s);
	public void delSupp(Supplier sp);
	public void modifySupp();
	public List<Supplier> getSupp();
	public void updatesupplier(Supplier sup);
	public List<Supplier> getSupplierById(String sid);
}
