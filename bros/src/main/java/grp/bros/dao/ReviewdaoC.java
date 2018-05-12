package grp.bros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grp.bros.model.Review;
@Repository
public class ReviewdaoC implements Reviewdao {
@Autowired
SessionFactory sf;
Transaction t;
	public void addReview(Review review) {
		int id=0;
		Session s=sf.openSession();
		t=s.beginTransaction();
		try{

			Query q=s.createQuery("select max(sno) from review");
		id=(Integer) q.list().get(0);
		}
		catch(Exception e)
		{	System.out.println(e);
			System.out.println(id);
		}
		review.setSno(id+1);
		s.save(review);
		t.commit();
	}
	public List<Review> getPageReviews() {
	Session ses=sf.openSession();
			t=ses.beginTransaction();
		Query q=ses.createQuery("from Review where xid IS NULL");
		List<Review> reviews=q.list();
return reviews;			
	}

}
