package grp.bros.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import grp.bros.dao.Reviewdao;
import grp.bros.model.Category;
import grp.bros.model.Products;
import grp.bros.model.Review;
import grp.bros.model.Supplier;
import grp.bros.model.UserData;
import grp.bros.model.UserDetails;
import grp.bros.service.Categoryservice;
import grp.bros.service.Productservice;
import grp.bros.service.Supplierservice;
import grp.bros.service.Userdetailsservice;

@Controller
public class Basiccontrols {
	@Autowired
	private Productservice pservice;
	@Autowired
	private Userdetailsservice udservice;
	@Autowired
	private Supplierservice sservice;
	@Autowired
	private Reviewdao rev;
	
private String mid,pw;
@RequestMapping(value={"/","/hom"})
public ModelAndView land(){
	
	return new ModelAndView("home");
}
@RequestMapping("/log")
public ModelAndView log(@ModelAttribute("userDetails")UserDetails ud){
	return new ModelAndView("login");
}

@RequestMapping("/reg")
public ModelAndView reg(@ModelAttribute("userDetails")UserDetails ud){
	return new ModelAndView("register");
}
@RequestMapping("/abt")
public ModelAndView abt(){
	
	ModelAndView m= new ModelAndView("contact");
	List<Review> reviews=rev.getPageReviews();
	m.addObject("comments", reviews);
	return m;
}


@RequestMapping("/pagereview")
public String writereview(@ModelAttribute("review")Review r,Principal user){
r.setMid(user.getName());
rev.addReview(r);	
return "redirect:abt";
}

@RequestMapping("/validate")
public ModelAndView sec(Principal principal)    /*@RequestParam("mid")String mid,@RequestParam("password")String pw*/
{ 
	/*
	
	if(udservice.validUser(mid,pw)==true)
	{
	*/ModelAndView successadmin=new ModelAndView("adminhome");
	ModelAndView successuser=new ModelAndView("userhome");
	ModelAndView successother=new ModelAndView("userhome");
	List<UserDetails> l=udservice.getUserById(principal.getName());     /*mid */
		if(l.get(0).isEnabled()==true)
		{
		if(l.get(0).getRole().equals("ROLE_ADMIN"))
			{
		successadmin.addObject("name",l.get(0).getFname()+" "+l.get(0).getSname());
		return successadmin;
		
			}
			else if(l.get(0).getRole().equals("ROLE_USER")){

				successuser.addObject("name",l.get(0).getFname()+" "+l.get(0).getSname());
				return successuser;
			}
			else
		return successother;
			
		}
		else {
			return new ModelAndView("failure");
		}
	/*}else
	{
		return new ModelAndView("failure");
		
	}*/
}

@RequestMapping("/loginfailure")
public ModelAndView failurepage(@RequestParam("error")String error){
	ModelAndView mv=new ModelAndView("failure"); 
	mv.addObject("error",error);
	return mv; 
}

@RequestMapping("/shop")
public ModelAndView abdct(){
	System.out.println("gfnjhfvf//");
	return new ModelAndView("shop");
}

@RequestMapping("/registeruser")
public ModelAndView reguser(@ModelAttribute("userDetails")UserDetails ud)
{
	System.out.println(ud.getFname()+""+ud.getPassword()+""+ud.getRepassword());
	if(ud.getPassword().equals(ud.getRepassword()))
	{	
		ud.setRole("ROLE_USER");
		ud.setEnabled(true);
		udservice.setUser(ud);
	}
	else
	{	System.out.println("password mismatch");
	return new ModelAndView("failure");
	}
	return new ModelAndView("login");
	
}




}








/*@RequestMapping("/validate")
public ModelAndView sec(@ModelAttribute("userDetails")UserDetails ud)
{ 
	
	ModelAndView success=new ModelAndView("adminheader");

	System.out.println("keko keka " + ud.getMid() + " " + ud.getPassword());
	mid=ud.getMid();
	pw=ud.getPassword();
	if(udservice.validUser(mid,pw)==true)
	{
		List<UserDetails> l=udservice.getUserById(ud.getMid());
		if(l.get(0).isAdmin()==true)
		{
		success.addObject("name",l.get(0).getFname()+l.get(0).getSname());
		return success;
		}
		else
			return new ModelAndView("userhome");
	}else
		return new ModelAndView("failure");
	
}
*/