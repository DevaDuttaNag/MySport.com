package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review {
@Id
int Sno;
String mid;
int rating;
String comment;
String xid;
public int getSno() {
	return Sno;
}
public String getMid() {
	return mid;
}
public int getRating() {
	return rating;
}
public String getComment() {
	return comment;
}
public String getXid() {
	return xid;
}
public void setSno(int sno) {
	Sno = sno;
}
public void setMid(String mid) {
	this.mid = mid;
}
public void setRating(int rating) {
	this.rating = rating;
}
public void setComment(String comment) {
	this.comment = comment;
}
public void setXid(String xid) {
	this.xid = xid;
}

}
