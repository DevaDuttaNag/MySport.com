package grp.bros.dao;

import java.security.Principal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grp.bros.model.Cart;
import grp.bros.model.Usercart;
@Repository
public class CartdaoC implements Cartdao {
@Autowired
SessionFactory sf;
Transaction t;

	public void addItemToCart(Cart c) {
		int id=0;
		Session s=sf.openSession();
		t=s.beginTransaction();
		try{

			Query q=s.createQuery("select max(ciid) from Cart");
		id=(Integer) q.list().get(0);
		}
		catch(Exception e)
		{	System.out.println(e);
			System.out.println(id);
		}
		c.setCiid(id+1);
		System.out.println(c.getCiid()+""+c.getMid()+""+c.getPrice()+""+c.getSize()+""+c.getXid());
		s.save(c);
		t.commit();
	}

	public List<Usercart> getUserCart(Principal actuser) {
	String mid=actuser.getName();
		Session s2=sf.openSession();
		t=s2.beginTransaction();
		Query q=s2.createQuery("from Usercart where mid='"+mid+"'");
		List<Usercart> uc=q.list();
		t.commit();
		return uc;
	}

	public void deleteItemById(String xid) {
		Session del=sf.openSession();
		t=del.beginTransaction();
		System.out.print("del");
		Query q=del.createQuery("delete from Cart where xid='"+xid+"'");
		q.executeUpdate();
		t.commit();
		System.out.println("leted");
	}

	public void clearCart(String mid) {
		Session clearC=sf.openSession();
		t=clearC.beginTransaction();
		Query q=clearC.createQuery("delete from Cart where mid='"+mid+"'");
		q.executeUpdate();
		t.commit();
		
	}

	

	

	/*@Override
	public void updateQtyById(String xid,String qty) {
		Session del=sf.openSession();
		t=del.beginTransaction();
		Query q=del.createQuery("update Cart set quantity='"+qty+"'where xid='"+xid+"'");
		
		q.executeUpdate();
		t.commit();
		
		
	}
	
	*/

}
