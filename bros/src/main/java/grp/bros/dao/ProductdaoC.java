package grp.bros.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import grp.bros.model.Login;
import grp.bros.model.Products;
import grp.bros.model.UserDetails;


@Repository
public class ProductdaoC implements Productdao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<Products> getProducts() {
		Session ses=sessionFactory.openSession();
		Query q=ses.createQuery("from Products");
		List<Products> lt=q.list();
			return lt;
	}

	
	public void addproduct(Products pd) {
		Session ss=sessionFactory.openSession();
		Transaction t=ss.beginTransaction();
		pd.setPid(setid(pd.getPcat()));
		ss.save(pd);
		t.commit();
		ss.close();
	}


	public String setid(String cat) {
		String id=null;
		int num,count=0;
	Session s1=sessionFactory.openSession();
		try{	
		Query hql=s1.createQuery("select max(pid) from Products where pcat='"+cat+"'");
		id=hql.list().get(0).toString();
		}
		catch(Exception e)
		{
			System.out.println(e+"the query");
			Query hql=s1.createQuery("select catid from Category where catname='"+cat+"'");
			id=hql.list().get(0).toString();	
		}	
		String sub1=id.substring(0,3);
			String sub2=id.substring(3);
			num=Integer.parseInt(sub2);
			num=num+1;
			int num2=num;
			while(num>0)
			{
				count++;
				num/=10;
			}
			if(count==1){
				id=sub1+"000"+num2;
			}else if(count==2){
				id=sub1+"00"+num2;
			}else if(count==3){
				id=sub1+"0"+num2;
			}else if(count==4){
				id=sub1+num2;
			};/*else if(count==5){
				id=sub1+num2;
			}*/
		s1.close();
		return id;		
	}

	

	
	public List<Products> getProductsById(String uid) {
	
		Session sess=sessionFactory.openSession();
		Transaction t=sess.beginTransaction();
		Query qu=sess.createQuery("from Products where pid='"+uid+"'");
		System.out.println("prods dao enter");

		List<Products> li= (List<Products>) qu.list();
		System.out.println("prods: "+li.get(0).getPcat());

		t.commit();
		System.out.println("prods dao exit");
	return li;	
	}

	
	public void updproduct(Products p) {
		Session s=sessionFactory. openSession();
		Transaction t=s.beginTransaction();
		s.update(p);
		t.commit();
		s.close();
		
	}

	
}