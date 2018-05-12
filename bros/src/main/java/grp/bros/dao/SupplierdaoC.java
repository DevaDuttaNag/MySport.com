package grp.bros.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import grp.bros.model.Products;
import grp.bros.model.Supplier;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class SupplierdaoC implements Supplierdao {
	@Autowired
	SessionFactory sesfac;


	public void addSupp(Supplier s) {
Session ses=sesfac.openSession();
Transaction t=ses.beginTransaction();
s.setSupid(setid(s.getSupname()));
ses.save(s);
t.commit();

	}

	
	public void delSupp(Supplier s) {
		Session ds=sesfac.openSession();
Transaction t=ds.beginTransaction();
System.out.println("mama");
	ds.delete(s);
	t.commit();
	}

	
	public void modifySupp() {

	}

	
	public List<Supplier> getSupp() {
		Session ses=sesfac.openSession();
		Query q=ses.createQuery("from Supplier");
		List<Supplier> lt=q.list();
		return lt;
	}
	

	public String setid(String name) {
		String id=null;
		int num,count=0;
	Session s1=sesfac.openSession();
			Query hql=s1.createQuery("select max(supid) from Supplier");
			System.out.println("the query getting executed");
			id=hql.list().get(0).toString();
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
				id=sub1+"00"+num2;
			}else if(count==2){
				id=sub1+"0"+num2;
			}else if(count==3){
				id=sub1+num2;
			}
		s1.close();
		return id;		
	}


	
	public void updateSupplier(Supplier sup) {
		
		Session s=sesfac.openSession();
		Transaction t=s.beginTransaction();
		s.update(sup);
		t.commit();
		s.close();
		
	}



	public List<Supplier> getSupplierById(String sid) {
		Session sess=sesfac.openSession();
		Transaction t=sess.beginTransaction();
		Query qu=sess.createQuery("from Supplier where supid='"+sid+"'");

		List<Supplier> li= (List<Supplier>) qu.list();

		t.commit();
	return li;	
	}

}
