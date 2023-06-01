package com.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Orders;
import com.bean.Product;
import com.service.OrdersService;
import com.service.ProductService;

@Controller
public class OrdersController {

	@Autowired
	ProductService productService;
	@Autowired
	OrdersService ordersService;
	
	@RequestMapping(value = "placeOrder/{pid}")
	public String placeOrder(Model mm,@PathVariable("pid") int pid,HttpSession hs,Orders order) {
		//System.out.println("Pid is "+pid);
		String emailid = (String)hs.getAttribute("emailid");
		
		order.setEmailid(emailid);
		order.setOrderplaced(LocalDate.now());
		order.setProductid(pid);
		String result = ordersService.placeOrder(order);
		
		//notify customer to login if emailid is not set
		if (emailid == null) {
			result = "Please login to place an order.";
			List<Product> listOfProducts = productService.findAllProduts();
			mm.addAttribute("products", listOfProducts);
			mm.addAttribute("msg", result);
			return "viewProduct";
		}
		
		productService.decrementQty(pid);
		List<Product> listOfProducts = productService.findAllProduts();
		mm.addAttribute("products", listOfProducts);
		mm.addAttribute("msg", result);
		return "viewProduct";
	}	
	
	@RequestMapping(value = "/viewOrders")
	public String viewOrders(Model mm,HttpSession hs, Orders order) {
		//System.out.println("Pid is "+pid);
		String emailid = (String)hs.getAttribute("emailid");
		String typeofuser = (String)hs.getAttribute("typeofuser");
		order.setEmailid(emailid);
		String result = "";
		List<Orders> listOfOrders;
//		System.out.println("inside view orders: admin email: "+emailid);
//		System.out.println("inside view orders: admin typeofuser: :"+typeofuser+":");
		
		if (typeofuser == null ) {
			result = "Please login to view your orders.";
			//System.out.println("inside view orders: check null typeofuser: "+ typeofuser);
			//listOfOrders = ordersService.findAllOrders();
			//mm.addAttribute("orders", listOfOrders);
			//mm.addAttribute("msg", result);
			return "viewOrders";
			
		}
		else if(typeofuser.equals("admin")) {
			result = "Viewing all Orders.";
			listOfOrders = ordersService.findAllOrders();
			//System.out.println("inside view orders: admin check");
			mm.addAttribute("orders", listOfOrders);
			mm.addAttribute("msg", result);
			return "viewOrders";
			
		}
		result = emailid+" Orders.";
		listOfOrders = ordersService.findOrdersByEmailId(emailid);
		mm.addAttribute("orders", listOfOrders);
		mm.addAttribute("msg", result);
		return "viewOrders";
	}
}