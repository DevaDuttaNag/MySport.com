package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
@Id
int ciid;
String xid;
String Quantity;
public String getQuantity() {
	return Quantity;
}
public void setQuantity(String quantity) {
	Quantity = quantity;
}
String mid;
String size;
int price;


public void setCiid(int ciid) {
	this.ciid = ciid;
}
public int getCiid() {
	return ciid;
}
public String getXid() {
	return xid;
}
public void setXid(String xid) {
	this.xid = xid;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}



}
