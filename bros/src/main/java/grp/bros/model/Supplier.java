package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Supplier {
	@Id
	String supid;
	String supname,supaddress,supemail,listproducts,status;
	long supcontact;
	public String getSupid() {
		return supid;
	}

	public void setSupid(String supid) {
		this.supid = supid;
	}

	public String getSupname() {
		return supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public long getSupcontact() {
		return supcontact;
	}

	public void setSupcontact(long supcontact) {
		this.supcontact = supcontact;
	}

	public String getSupaddress() {
		return supaddress;
	}

	public void setSupaddress(String supaddress) {
		this.supaddress = supaddress;
	}

	public String getSupemail() {
		return supemail;
	}

	public void setSupemail(String supemail) {
		this.supemail = supemail;
	}

	public String getListproducts() {
		return listproducts;
	}

	public void setListproducts(String listproducts) {
		this.listproducts = listproducts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
