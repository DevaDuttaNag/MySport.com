package grp.bros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grp.bros.model.UserDetails;

@Repository
public class UserdetailsdaoC implements Userdetailsdao {
@Autowired
	SessionFactory sessionFactory;
	
	public boolean validUser(String mid,String pw) {
	String dl="",dp="";
		Session s=sessionFactory.openSession();
		Query q=s.createQuery("from UserDetails where mid='"+mid+"'");
		List<UserDetails> lst=q.list();
		for(UserDetails l:lst)
		{
		System.out.println(l.getMid()+" "+l.getPassword());
		dl=l.getMid();
		dp=l.getPassword();	
		}
		if((mid).equals(dl) && pw.equals(dp)){
			System.out.println("checking values");
			return true;}
		else{
			System.out.println("failure case");	
			return false;
		}
		}

	
	public void setUser(UserDetails ud) {

		Session sess=sessionFactory.getCurrentSession();
		Transaction t=sess.beginTransaction();
		sess.save(ud);
		t.commit();
	}

	
	public List<UserDetails> getUserById(String mid) {
		Session ss=sessionFactory.openSession();
		Query q=ss.createQuery("from UserDetails where mid='"+mid+"'");
		List<UserDetails> l=q.list();
		return l;
	}


	public void updateAddress(UserDetails ud, String name) {
		Session updadd=sessionFactory.getCurrentSession();
		Transaction t=updadd.beginTransaction();
		UserDetails data=updadd.get(UserDetails.class,name);
		data.setLoc(ud.getLoc());
		data.setArea(ud.getArea());
		data.setCity(ud.getCity());
		data.setHno(ud.getHno());
		data.setPhone(ud.getPhone());
		data.setState(ud.getState());
		data.setStreet(ud.getStreet());
		updadd.update(data);
		t.commit();		
		
	}


	
}
