package com.bee.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value = "/pages/admin")
	public String getAdminLogin(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/login";
	}
	
	@RequestMapping(value = "/pages/admin/category")
	public String getCategory(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/category";
	}
	
	@RequestMapping(value = "/pages/admin/category/create")
	public String getCategoryCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/category_create";
	}
	
	@RequestMapping(value = "/pages/admin/category/{id}")
	public String getCategoryEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/category_edit";
	}
	
	@RequestMapping(value = "/pages/admin/brand")
	public String getBrand(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/brand";
	}
	
	@RequestMapping(value = "/pages/admin/brand/create")
	public String getBrandCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/brand_create";
	}
	
	@RequestMapping(value = "/pages/admin/brand/{id}")
	public String getBrandEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/brand_edit";
	}
	
	@RequestMapping(value = "/pages/admin/product")
	public String getProduct(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/product";
	}
	
	@RequestMapping(value = "/pages/admin/product/create")
	public String getProductCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/product_create";
	}
	
	@RequestMapping(value = "/pages/admin/product/{id}")
	public String getProductEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/product_edit";
	}
	
	@RequestMapping(value = "/pages/admin/product/{id}/view")
	public String getProductView(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/product_view";
	}
	
	@RequestMapping(value = "/pages/admin/user")
	public String getUsers(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/user";
	}
	
	@RequestMapping(value = "/pages/admin/user/create")
	public String getUserCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/user_create";
	}
	
	@RequestMapping(value = "/pages/admin/user/{id}")
	public String getUserEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/user_edit";
	}
	
	@RequestMapping(value = "/pages/admin/customer")
	public String getCustomer(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/customer";
	}
	
	@RequestMapping(value = "/pages/admin/customer/create")
	public String getCustomerCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/customer_create";
	}
	
	@RequestMapping(value = "/pages/admin/customer/{id}")
	public String getCustomerEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/customer_edit";
	}
	
	@RequestMapping(value = "/pages/admin/plan")
	public String getPlan(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/plan";
	}
	
	@RequestMapping(value = "/pages/admin/plan/create")
	public String getPlanCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/plan_create";
	}
	
	@RequestMapping(value = "/pages/admin/plan/{id}")
	public String getPlanEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/plan_edit";
	}
	
	@RequestMapping(value = "/pages/admin/purchase")
	public String getPurchase(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/purchase";
	}
	
	@RequestMapping(value = "/pages/admin/purchase/create")
	public String getPuchaseCreate(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "admin/purchase_create";
	}
	
	@RequestMapping(value = "/pages/admin/purchase/{id}")
	public String getPurchaseEdit(@PathVariable String id, Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		model.addAttribute("id", id);
		return "admin/purchase_edit";
	}
	
	@RequestMapping(value = "/")
	public String getCustomerEdit(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "index";
	}
	
	@RequestMapping(value = "/pages/login")
	public String getCustomerLogin(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "login";
	}
	
	@RequestMapping(value = "/pages/register")
	public String getCustomerRegister(Model model) {
		String url = "http://localhost:" + port;
		model.addAttribute("URL", url);
		return "register";
	}
}
