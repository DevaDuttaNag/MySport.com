package grp.bros.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import grp.bros.model.Category;
import grp.bros.model.Products;

@Repository
public class CategorydaoC implements Categorydao {
@Autowired
SessionFactory sf;
	
	public void addcategory(Category c) {
		System.out.println(c.getCatid()+""+c.getCatname());
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(c);
		t.commit();
		s.close();
	}

	public List<Category> getCat() {
		Session s=sf.openSession();
		Query q=s.createQuery("from Category");
		List<Category> l=q.list();
		return l;
	}

	public List<Category> getCatname() {
		Session sc=sf.openSession();
		Query qry=sc.createQuery("select catname from Category");
		List<Category> li=qry.list();
		return li;
	}

	public List<Category> getCategoryById(String cid) {
		Session sess=sf.openSession();
		Transaction t=sess.beginTransaction();
		Query qu=sess.createQuery("from Category where catid='"+cid+"'");
		List<Category> li= (List<Category>) qu.list();
		t.commit();
		return li;
		}

	public void updateCategory(Category cate) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(cate);
		t.commit();
		s.close();
		
		
	}
	
/*
	Query q=s.createQuery("from category")
			List<Category> loc=q.list();	
*/			
	
}
