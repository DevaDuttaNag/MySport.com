package grp.bros.controller;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/*import org.h2.command.ddl.AlterUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import grp.bros.model.Category;
import grp.bros.model.Procatsup;
import grp.bros.model.Products;
import grp.bros.model.Supplier;
import grp.bros.service.Categoryservice;
import grp.bros.service.Productservice;
import grp.bros.service.Supplierservice;
*/
import grp.bros.dao.Cartdao;
import grp.bros.dao.Ordersdao;
import grp.bros.dao.Userdetailsdao;
import grp.bros.dao.Xmapdao;
import grp.bros.model.Cart;
import grp.bros.model.Orders;
import grp.bros.model.UserData;
import grp.bros.model.UserDetails;
import grp.bros.model.Usercart;


@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class UserController {
/*	@Autowired
	private Supplierservice ss;
	@Autowired
	private Productservice pservice;
	@Autowired
	private Categoryservice categoryserviceC;*/
	@Autowired
	private Xmapdao xmap;
	@Autowired
	private Cartdao cd;
	@Autowired
	Ordersdao od;
	@Autowired
	Userdetailsdao udd;
@Autowired
private Userdetailsdao ud;
	
@RequestMapping("/shop")
public ModelAndView getUserData()
{	
	ModelAndView mav=new ModelAndView("shopping");
	List<UserData> l=xmap.getUserData();
	System.out.println(l.get(0).getXid());
	mav.addObject("udata", l);
	return mav;	
}

@RequestMapping("/user_addprod")
public String addprod(@RequestParam("id")String dtc,@RequestParam("quantity")String qty,Principal actuser)
{	
	System.out.println(qty+"   "+dtc);
	Cart c=new Cart();
	UserData ud=xmap.getUserDataById(dtc);
	c.setQuantity(qty);
	c.setMid(actuser.getName());
	c.setPrice(ud.getPrice());
	c.setSize(ud.getPsize());
	c.setXid(dtc);
	cd.addItemToCart(c);
	System.out.println("item added to cart check out");
	return  "redirect:shop";
	
}

@RequestMapping("/user_cart")
public ModelAndView showcart(Principal actuser)
{

	ModelAndView ucart=new ModelAndView("usercart");
	List<Usercart> uc=cd.getUserCart(actuser);
	UserDetails address=ud.getUserById(actuser.getName()).get(0);
	
	ucart.addObject("shippingdetails",address );

	ucart.addObject("usercartitems",uc);
	
	return ucart;
}
@RequestMapping("/user_removeitem")
public String deleteitem(@RequestParam("id")String xid)
{	
	cd.deleteItemById(xid);
	return "redirect:user_cart";
}
@RequestMapping("/user_clearcart")
public String deleteitem(Principal actuser)
{	
	cd.clearCart(actuser.getName());
	return "redirect:user_cart";
}
@RequestMapping("/user_placeorder")
public ModelAndView placeorder(@ModelAttribute("UserDetails")UserDetails ud,Principal actuser)  /*,@RequestParam("add")String checked*/
{	
	Orders o=new Orders();
	o.setMid(actuser.getName());
	o.setShipaddress(ud.getHno()+","+ud.getStreet()+","+ud.getLoc()+","+ud.getArea()+","+ud.getCity()+","+ud.getState());
	o.setShipno(ud.getPhone());
	 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	o.setOrderdate(timestamp);
	o.setOrderstatus("PLACED");
	if(ud.getUpdate()==null){
		ud.setUpdate("false");
	}
	else if(ud.getUpdate().equals("true"))
	{System.out.println("ok na");
	udd.updateAddress(ud,actuser.getName());
	}
	
	od.placeOrder(o);
	return new ModelAndView("regsuccess");
}
/*@RequestMapping("/user_updateqty")
public String updateQty(@RequestParam("id")String xid,@RequestParam("quantity")String qty)
{
	cd.updateQtyById(xid,qty);
	return "redirect:user_cart";
}*/


}
