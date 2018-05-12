package grp.bros.model;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
@Entity
@Table
public class Products {
@Id
private String pid;
private String pname,pcat;



public String getPcat() {
	return pcat;
}
public void setPcat(String pcat) {
	this.pcat = pcat;
}
public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}

public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}

}
