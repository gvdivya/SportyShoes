package com.controller;

import java.util.List;
import java.util.Locale.Category;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



@Controller
@SessionAttributes({"adminName"})
public class CRUDController {

	
	
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	CategoriesDAO cdao;
	
	@Autowired
	AdminDAO aDao;
	
	
	@Autowired
	UsersDAO udao;
	
	@RequestMapping("login")

	public ModelAndView login(@RequestParam("pwd") String pwd, @RequestParam("aname") String aname, 
			HttpServletRequest req, HttpServletResponse res, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		
		boolean login_success = false;
		Admin admin = aDao.getByaName(aname);
		if(admin.getPwd().equals(pwd)) {
			login_success = true;
		}
		
		if (login_success == true) {
			session.setAttribute("adminName", aname);
			mv.setViewName("loginsuccess");
			
		} else {
			mv.setViewName("loginFailure");
		}
		return mv;

	}
	
	@RequestMapping("changepasswordjsp")
	public ModelAndView updatepasswordjsp(
	HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("changepassword");

		return mv;
	}
	
	
	
	@RequestMapping("changepassword")
	
	
	public ModelAndView updatepassword(@RequestParam("pwd") String pwd, @RequestParam("cpwd") String cpwd, 
			HttpServletRequest req, HttpServletResponse res, HttpSession session) {

		ModelAndView mv = new ModelAndView();
		System.out.println("userName: " + session.getAttribute("adminName"));
		
		
		if (pwd.equalsIgnoreCase(cpwd))
		{
			Admin a = new Admin();
			a.setAname(session.getAttribute("adminName").toString());
			a.setPwd(cpwd);
			aDao.changepassword(a);
			mv.setViewName("changepasswordstatus");
			
		} else {
			mv.setViewName("changepasswordfailurestatus");
		}
		
		
		
		return mv;

	}
	
	
	@RequestMapping("getallusers")

	public ModelAndView get(HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		List<Users> s = udao.getallusers();
		mv.setViewName("displayusers");
		mv.addObject("list", s);

		return mv;

	}
	
	@RequestMapping("dashboardjsp")

	public ModelAndView dashboardjsp(
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		
		
		
		mv.setViewName("loginsuccess");

		return mv;
	}
	
	
	@RequestMapping("logoutjsp")

	public ModelAndView logoutjsp(
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("logout");

		return mv;
	}
	
	
	@RequestMapping("loginjsp")

	public ModelAndView loginjsp(
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.");

		return mv;
	}
	
	
	@RequestMapping("findByName")
	public ModelAndView getByName(@RequestParam("name") String name, 
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		boolean userfound_success = false;
		Users users = udao.getByName(name);
		if(users.getName().equals(name)) {
			 userfound_success = true;
		}
		
		
		
		if ( userfound_success == true) {
			mv.addObject("users", users);
			mv.setViewName("userfoundsuccess");
			
		} else {
			mv.setViewName("usernotfound");
		}
		return mv;

	}
	
	
	

	@RequestMapping("getallcategories")

	public ModelAndView getcategories(HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		List<Categories> c = cdao.getallcategories();
		mv.setViewName("displaycategories");
		mv.addObject("list", c);

		return mv;

	}
	
	@RequestMapping("insertcategoryjsp")

	public ModelAndView insertcategoryjsp(
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("insertcategory");

		return mv;

	}
	
	
	
	@RequestMapping("insertcategory")

	public ModelAndView insertcategory(@RequestParam("cname") String cname,
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		List<Categories> caList = cdao.findAllByCategoriesName(cname);
		if(caList.size() > 0) {
			mv.setViewName("categoriesstatusfailure");
			return mv;
		}
		Categories us = new Categories();
		us.setCname(cname);
		
		Categories up =cdao.insertcategory(us);
		if (up != null) {
			mv.setViewName("categoriesstatus");
		}
		return mv;

	}
	
	
	@RequestMapping("deletecategories")
	public ModelAndView deletecategories(@RequestParam("cid") Integer cid,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cid :" + cid);
		cdao.deleteBycid(cid);
		
		ModelAndView mv = new ModelAndView();
		List<Categories> c = cdao.getallcategories();
		System.out.println("Category deleted");
		mv.setViewName("displaycategories");
		mv.addObject("list", c);

		return mv;
		
	}
	
	
	@RequestMapping("editcategories")
	public ModelAndView editcategories(@RequestParam("cid") Integer cid,
			@RequestParam("cname") String cname,
			HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("cid :" + cid);
		System.out.println("cname :" + cname);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("cid", cid);
		mv.addObject("cname", cname);
		mv.setViewName("editcategories");
		return mv;
		
	}
	
	@RequestMapping("updatecategory")
	public ModelAndView updatecategory(@RequestParam("cid") Integer cid,
			@RequestParam("cname") String cname,
			HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("cid :" + cid);
		System.out.println("cname :" + cname);
		Categories ca = new Categories();
		ca.cid = cid;
		ca.cname = cname;
		
		cdao.editcategories(ca);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("categoriesstatus");
		return mv;
		
	}
	
	
	
	
	
	@RequestMapping("getallproducts")

	public ModelAndView getallproducts(HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		List<Product> p = pdao.getallproducts();
		mv.setViewName("displayproducts");
		mv.addObject("list", p);

		return mv;

	}
	

	@RequestMapping("insertproductjsp")

	public ModelAndView insertproductjsp(
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		List<Categories> cs = cdao.getallcategories();
		mv.addObject("list", cs);
		mv.setViewName("insertproduct");
	
		return mv;

	}
	
	
	
	
	@RequestMapping("insertproduct")

	public ModelAndView insertproduct(@RequestParam("pname") String pname,
			@RequestParam("price") int price,
			@RequestParam("gender") String gender,
			@RequestParam("categories") String cname,
			HttpServletRequest req, HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		Product pp = new Product();
		pp.setPname(pname);
		pp.setPrice(price);
		pp.setGender(gender);
		
		//Categories ca = new Categories();
		//ca.setCname(categories);
		List<Categories> caList = cdao.findAllByCategoriesName(cname);
		Categories ca = cdao.findByCategoriesName(cname);
		//pp.categories = caList.get(0);
		pp.setCategories(ca);
		Product up = pdao.insertproduct(pp);
		if (up != null) {
			mv.setViewName("productstatus");
		}
		return mv;

	}
	
	@RequestMapping("deleteproduct")
	public ModelAndView deleteproduct(@RequestParam("pid") Integer pid,
			HttpServletRequest req, HttpServletResponse res) {
		System.out.println("pid :" + pid);
		pdao.deleteBypid(pid);
		
		ModelAndView mv = new ModelAndView();
		List<Product> p = pdao.getallproducts();
		System.out.println("Product deleted");
		mv.setViewName("displayproducts");
		mv.addObject("list", p);

		return mv;
		
	}
	
	
	
	
	
	@RequestMapping("editproduct")
	public ModelAndView editproduct(@RequestParam("pid") Integer pid,
			@RequestParam("pname") String pname,@RequestParam("price") Integer price,
			@RequestParam("gender") String gender,@RequestParam("categories") String categories,
			HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("pid :" + pid);
		System.out.println("pname :" + pname);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("pid", pid);
		mv.addObject("pname", pname);
		mv.addObject("price", price);
		mv.addObject("gender", gender);
		mv.addObject("categories", categories);
		List<Categories> cs = cdao.getallcategories();
		mv.addObject("list", cs);
		
	    mv.setViewName("editproduct");
		return mv;
		
	}
	
	
	
	
	@RequestMapping("updateproduct")
	public ModelAndView updateproduct(@RequestParam("pid") Integer pid,
			@RequestParam("pname") String pname,@RequestParam("price") Integer price,
			@RequestParam("gender") String gender,@RequestParam("categories") String cname,
			HttpServletRequest req, HttpServletResponse res) {
		
		System.out.println("pid :" + pid);
		System.out.println("pname :" + pname);
		
		System.out.println("price :" + price);
		System.out.println("gender :" + gender);
		Product pa = new Product();
		pa.pid = pid;
		pa.pname = pname;
		pa.price =price;
		pa.gender =gender;
		List<Categories> caList = cdao.findAllByCategoriesName(cname);
		pa.categories = caList.get(0);
		
		
		pdao.editproduct(pa);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("producteditstatus");
		return mv;
		
	}
}

	
	



	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	

	