package grp.bros.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import grp.bros.model.Category;
import grp.bros.model.Procatsup;
import grp.bros.model.Products;
import grp.bros.model.Supplier;
import grp.bros.model.UserData;

@Repository
public class XmapdaoC implements Xmapdao {
@Autowired
SessionFactory sefa;
Transaction t;

	public List<Procatsup> getXData() {
		Session sx=sefa.openSession();
		t=sx.beginTransaction();
		Query q=sx.createQuery("from Procatsup");
		List<Procatsup> xd=q.list();
		t.commit();
		return xd;
	}
	public List<Products> getAPid(){
		Session px=sefa.getCurrentSession();
		t=px.beginTransaction();
		Query q=px.createQuery("select pid from Products");
		List<Products> p=q.list();
		t.commit();
		return p;
	}
	public List<Supplier> getASupid(){
		Session sx=sefa.getCurrentSession();
		t=sx.beginTransaction();
		Query q=sx.createQuery("select supid from Supplier");
		List<Supplier> s=q.list();
		t.commit();
		return s;
	}public List<Category> getACatid(){
		Session cx=sefa.getCurrentSession();
		t=cx.beginTransaction();
		Query q=cx.createQuery("select catid from Category");
		List<Category> c=q.list();
		t.commit();
		return c;
	}
	public boolean addXdata(Procatsup xpcs) {
		xpcs.setXid(setid());
		try{
			Session s=sefa.getCurrentSession();
			t=s.beginTransaction();
			saveimage(xpcs.getImagefile(),xpcs.getXid());
			s.save(xpcs);
			t.commit();
			return true;
		}
		catch(Exception e){
			System.out.println(e);
		return false;
		}
	}
	
	
	private void saveimage(MultipartFile image, String xid) {
		Path path=Paths.get("F://dev//bros//src//main//webapp//resources//images//products//"+xid+".jpg");
		try
		{if(image!=null && !image.isEmpty())
		{
			System.out.println("\npath :" + path.toString());
			image.transferTo(new File(path.toString()));
			System.out.println("image saved check it");
		}
		}
		catch(Exception e){
		System.out.println("image not saved"+e);	
			
		}
	}
	
	private String setid() {
		String id=null;
		int num,count=0;
	Session s=sefa.openSession();
		Query hql=s.createQuery("select max(xid) from Procatsup");
		id=hql.list().get(0).toString();
		String sub1=id.substring(0,1);
			String sub2=id.substring(1);
			num=Integer.parseInt(sub2);
			num=num+1;
			int num2=num;
			while(num>0)
			{
				count++;
				num/=10;
			}
			if(count==1){
				id=sub1+"0000"+num2;
			}else if(count==2){
				id=sub1+"000"+num2;
			}else if(count==3){
				id=sub1+"00"+num2;
			}else if(count==4){
				id=sub1+"0"+num2;
			}
			else if(count==5){
				id=sub1+num2;
			};
		return id;		
	}
	public List<Procatsup> getXDataById(String id) {
		Session us=sefa.openSession();
		t=us.beginTransaction();
		Query q=us.createQuery("from Procatsup where xid='"+id+"'");
		List<Procatsup> dl=q.list();
		t.commit();
		return dl;
	}
	public void updateXData(Procatsup xpcs) {
		Session uds=sefa.openSession();
		t=uds.beginTransaction();
		uds.update(xpcs);
		System.out.println("query execute avatley");
		t.commit();
	}
	public List<UserData> getUserData() {
		Session gud=sefa.openSession();
		t=gud.beginTransaction();
		Query gd=gud.createQuery("from UserData");
		List<UserData> l=gd.list();
		return l;
	}
	public UserData getUserDataById(String xid) {
		Session gdid=sefa.openSession();
		t=gdid.beginTransaction();
		System.out.println(xid);
		UserData ud=(UserData)gdid.get(UserData.class,xid);
		System.out.println(ud.getPrice());
		return ud;
	}

	
}
