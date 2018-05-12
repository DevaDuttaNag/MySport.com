package grp.bros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grp.bros.dao.Supplierdao;
import grp.bros.model.Category;
import grp.bros.model.Supplier;
@Service
public class SupplierserviceC implements Supplierservice {
@Autowired
Supplierdao sd;
	public void addSupp(Supplier s) {
		sd.addSupp(s);
	}

	public void delSupp(Supplier s) {
sd.delSupp(s);
	}

	public void modifySupp() {
	}

	public List<Supplier> getSupp() {
		List<Supplier> lt=sd.getSupp();
		return lt;
	}


	public void updatesupplier(Supplier sup) {
		sd.updateSupplier(sup);
	}

	public List<Supplier> getSupplierById(String sid) {
		List<Supplier> l=sd.getSupplierById(sid);
		return l;
	}

}
