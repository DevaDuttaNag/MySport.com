package grp.bros.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {
@Id
private String catid; 
private String catname;
public String getCatid() {
	return catid;
}
public void setCatid(String catid) {
	this.catid = catid;
}
public String getCatname() {
	return catname;
}
public void setCatname(String catname) {
	this.catname = catname;
}
	
}
