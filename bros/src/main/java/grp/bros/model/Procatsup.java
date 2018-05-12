package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Procatsup {
@Id
String xid;
String pid,supid,catid,status,psize;
@Transient
private MultipartFile imagefile;

public MultipartFile getImagefile() {
	return imagefile;
}
public void setImagefile(MultipartFile imagefile) {
	this.imagefile = imagefile;
}
public String getPsize() {
	return psize;
}
public void setPsize(String psize) {
	this.psize = psize;
}
int price,stock;

public String getXid() {
	return xid;
}
public void setXid(String xid) {
	this.xid = xid;
}
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
public String getCatid() {
	return catid;
}
public void setCatid(String catid) {
	this.catid = catid;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	
	
}
