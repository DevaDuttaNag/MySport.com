package grp.bros.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import grp.bros.model.Orders;

@Repository
public class OrdersdaoC implements Ordersdao {
@Autowired
SessionFactory sf;
Transaction t;


public void placeOrder(Orders o) {
	Session s=sf.openSession();
	t=s.beginTransaction();
	o.setOid("1");
	s.save(o);
	t.commit();
}



}
