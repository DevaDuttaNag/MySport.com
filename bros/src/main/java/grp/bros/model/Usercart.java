package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Entity
public class Usercart {
@Id
String ciid;
String xid,mid,pname,supname,psize;
public String getPsize() {
	return psize;
}
public int getQuantity() {
	return quantity;
}
int quantity;
int price;
public String getCiid() {
	return ciid;
}
public String getXid() {
	return xid;
}
public String getMid() {
	return mid;
}
public String getPname() {
	return pname;
}
public String getSupname() {
	return supname;
}
public int getPrice() {
	return price;
}
}
