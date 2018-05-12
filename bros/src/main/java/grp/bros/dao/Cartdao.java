package grp.bros.dao;


import java.security.Principal;
import java.util.List;

import grp.bros.model.Cart;
import grp.bros.model.Usercart;

public interface Cartdao {

	public void addItemToCart(Cart c);

	public List<Usercart> getUserCart(Principal actuser);

	public void deleteItemById(String xid);

	public void clearCart(String mid);

/*	public void updateQtyById(String xid,String qty);*/
}
