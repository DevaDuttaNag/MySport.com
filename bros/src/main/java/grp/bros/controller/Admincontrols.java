package grp.bros.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import grp.bros.model.Category;
import grp.bros.model.Products;
import grp.bros.model.Supplier;
import grp.bros.service.Categoryservice;
import grp.bros.service.Productservice;
import grp.bros.service.Supplierservice;

@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class Admincontrols {
@Autowired
private Supplierservice ss;
@Autowired
private Productservice pservice;
@Autowired
private Categoryservice categoryserviceC;

@RequestMapping("/discat")
public ModelAndView displaycategory(@ModelAttribute("category")Category c)
{
return new ModelAndView("admincategory");
}


@RequestMapping("/addcat")
public ModelAndView adcat(@ModelAttribute("category")Category c)
{
	
	return new ModelAndView("addcategory");
}



@RequestMapping("/addcategory")
public ModelAndView addcat(@ModelAttribute("category")Category c){
	System.out.println(c.getCatid()+""+c.getCatname());
	categoryserviceC.addcategory(c);
	return new ModelAndView("regsuccess");
}
@RequestMapping("updcat")
public ModelAndView updcat(@RequestParam("id")String cid)
{
ModelAndView mav=new ModelAndView("updatecategory");
Category cat=categoryserviceC.getCategoryById(cid).get(0);

mav.addObject("ucat",cat);
return mav;
}
@RequestMapping("updcategory")
public ModelAndView upddcategory(@ModelAttribute("category")Category c)
{
categoryserviceC.updatecategory(c);	
return new ModelAndView("admincategory");
}

@RequestMapping("/disprods")
public ModelAndView displayproducts(@ModelAttribute("products")Products pd)
{
	System.out.println("admin disp products req");

return new ModelAndView("adminproducts");	
}

@RequestMapping("/addprods")
public ModelAndView adprods(@ModelAttribute("products")Products pd)
{
	System.out.println("admin addd products req");
	ModelAndView mv=new ModelAndView("addproducts");
	
	List<Category> lt=categoryserviceC.getCatname();
	mv.addObject("categories", lt);
	return mv;
}
@RequestMapping("/updprods")
public ModelAndView updateproducts(@RequestParam("id")String uid){
	
	System.out.println(uid);	
	System.out.println("prods controller enter");
	ModelAndView mv=new ModelAndView("updateproducts");
	Products prd=  pservice.getProductsByID(uid).get(0);
	System.out.println(prd.getPcat());
	System.out.println("prods controller exit");
	List<Category> lt=categoryserviceC.getCatname();
	mv.addObject("categories", lt);
	mv.addObject("upro",prd );
	return mv;
}
@RequestMapping("/addproduct")
public ModelAndView addproduct(@ModelAttribute("products")Products pd)
{
	pservice.addproduct(pd);
	return new ModelAndView("regsuccess");
}
@RequestMapping("/updproduct")
public ModelAndView updproduct(@ModelAttribute("products")Products pd)
{
	
pservice.updproduct(pd);	
return new ModelAndView("adminproducts");
}

@RequestMapping("/dissup")
public ModelAndView displaysuplier(@ModelAttribute("supplier")Supplier s)
{
return new ModelAndView("adminsupplier");
}
@RequestMapping("/addsup")
public ModelAndView adsup(@ModelAttribute("supplier")Supplier s)
{
	return new ModelAndView("addsupplier");
}
	@RequestMapping("/addsupplier")
	public ModelAndView addsup(@ModelAttribute("supplier")Supplier s){
		ss.addSupp(s);
		return new ModelAndView("regsuccess");
	}

	
	@RequestMapping("/delsupplier")
	public ModelAndView delsup(@ModelAttribute("supplier")Supplier s){
	
		ss.delSupp(s);
		return new ModelAndView("regsuccess");
	}
	@RequestMapping("getsupplier")
	public ModelAndView getsup(){
		return new ModelAndView("regsuccess");
	}

@RequestMapping("updsup")
public ModelAndView updsupp(@RequestParam("id")String sid)
{

ModelAndView mav=new ModelAndView("updatesupplier");
Supplier sup=ss.getSupplierById(sid).get(0);
mav.addObject("usup",sup);
return mav;
}
@RequestMapping("updsupplier")
public ModelAndView upddsuplier(@ModelAttribute("supplier")Supplier s)
{
ss.updatesupplier(s);	
return new ModelAndView("adminsupplier");
}
	

@RequestMapping("/GsonCon")
public @ResponseBody String getproductValues() {
		
	//ndd = new NetworkDevDAOImpl();
	String prods="";		
		System.out.println("gson all products...");
		List<Products> lst=pservice.getProducts();
		
		Gson gson = new Gson();
		prods=gson.toJson(lst);	
	return prods;
}
@RequestMapping("/GsonConS")
public @ResponseBody String getsupplierValues() {
		
	String prods="";		
		System.out.println("gson all products...");
		List<Supplier> lt=ss.getSupp();
		Gson gson = new Gson();
		prods=gson.toJson(lt);	
	return prods;
}
@RequestMapping("/GsonConC")
public @ResponseBody String getCategoryValues() {
		
	String prods="";		
		System.out.println("gson all products...");
		List<Category> lt=categoryserviceC.getCat();
		System.out.println(lt.get(0).getCatid()+""+lt.get(0).getCatname());
		Gson gson = new Gson();
		prods=gson.toJson(lt);	
	return prods;
}
@RequestMapping("adminhom")
public ModelAndView adminpage(){
	return new ModelAndView("adminhome");
}
@RequestMapping("userhom")
public ModelAndView userpage(){
	return new ModelAndView("userhome");
}
/*@ModelAttribute("categories")
public List<Category> getCategories() 
{
	int i=0;
	List<Category> lt=categoryserviceC.getCatname();
	List<String> cats = null;
	while(lt!=null)
	{	
		cats.add(lt.get(i).getCatname());
	i++;
	}
	return lt;
}*/

}
