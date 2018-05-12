package grp.bros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import grp.bros.dao.Xmapdao;
import grp.bros.model.Category;
import grp.bros.model.Procatsup;
import grp.bros.model.Products;
import grp.bros.model.Supplier;
import grp.bros.service.Categoryservice;
import grp.bros.service.Productservice;
import grp.bros.service.Supplierservice;

@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class Admincontrols2{
@Autowired
private Supplierservice ss;
@Autowired
private Productservice pservice;
@Autowired
private Categoryservice categoryserviceC;
@Autowired
private Xmapdao xmap;

@RequestMapping("admin_Xmapdata")
public ModelAndView Xmap(@ModelAttribute("procatsup")Procatsup pcs){
ModelAndView xmd=new ModelAndView("Xdata");
	List<Procatsup>	xdata=xmap.getXData();
	List<Products>	pdata=xmap.getAPid();
	List<Supplier>	sdata=xmap.getASupid();
	List<Category>	cdata=xmap.getACatid();
	System.out.println("data: "+xdata.get(0).getCatid());
	xmd.addObject("xdata", xdata);
	xmd.addObject("pdata", pdata);
	xmd.addObject("sdata", sdata);
	xmd.addObject("cdata", cdata);
	return xmd;
}

@RequestMapping("admin_addXdata")
public String addxmapdata(@ModelAttribute("procatsup")Procatsup xpcs)
{
	xpcs.setStatus("available");
	boolean check=xmap.addXdata(xpcs);
	if(check==true){

	return "redirect:admin_Xmapdata";
	
	}
	else
	{
		return "failure";
	}	
}

@RequestMapping("updXdata")
public ModelAndView updpage(@RequestParam("id")String xid)
{
	ModelAndView uv=new ModelAndView("UpdateXdata");
	List<Procatsup> xdl=xmap.getXDataById(xid);
	List<Products>	pdata=xmap.getAPid();
	List<Supplier>	sdata=xmap.getASupid();
	List<Category>	cdata=xmap.getACatid();
	uv.addObject("uxdata", xdl.get(0));
	uv.addObject("pdata", pdata);
	uv.addObject("sdata", sdata);
	uv.addObject("cdata", cdata);
	return uv;
}

@RequestMapping("admin_updXdata")
public String updxmapdata(@ModelAttribute("procatsup")Procatsup xpcs){
	xmap.updateXData(xpcs);
	return "redirect:admin_Xmapdata";
	
}
}