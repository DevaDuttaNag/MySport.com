package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserData {
@Id
String xid;
String pid,supid,psize,pname,supname,catname;
int stock,price;
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public String getSupid() {
	return supid;
}
public void setSupid(String supid) {
	this.supid = supid;
}

public String getXid() {
	return xid;
}
public void setXid(String xid) {
	this.xid = xid;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getSupname() {
	return supname;
}
public void setSupname(String supname) {
	this.supname = supname;
}
public String getCatname() {
	return catname;
}
public void setCatname(String catname) {
	this.catname = catname;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getPrice() {
	return price;
}
public String getPsize() {
	return psize;
}
public void setPsize(String psize) {
	this.psize = psize;
}
public void setPrice(int price) {
	this.price = price;
}


}
