package grp.bros.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Orders {
@Id
String oid;
String mid;
long shipno;
String shipaddress;
Timestamp orderdate;
String orderstatus;
public String getOid() {
	return oid;
}
public void setOid(String oid) {
	this.oid = oid;
}
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}

public long getShipno() {
	return shipno;
}
public void setShipno(long shipno) {
	this.shipno = shipno;
}
public String getShipaddress() {
	return shipaddress;
}
public void setShipaddress(String shipaddress) {
	this.shipaddress = shipaddress;
}
public Timestamp getOrderdate() {
	return orderdate;
}
public void setOrderdate(Timestamp orderdate) {
	this.orderdate = orderdate;
}
public String getOrderstatus() {
	return orderstatus;
}
public void setOrderstatus(String orderstatus) {
	this.orderstatus = orderstatus;
}




}
