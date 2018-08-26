package com.CoffeeShopCont.Lab24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CoffeeShopCont.Lab24.dao.ItemRepository;
import com.CoffeeShopCont.Lab24.entity.Item;

@Controller
public class HomeController {
	@Autowired
	ItemRepository itemDao;

//	@RequestMapping("/")
//	public ModelAndView home() {
//		
//		return new ModelAndView("index");
//	}
	
	@RequestMapping("/")
	public ModelAndView list() {
		System.out.println(itemDao.findAll());
		return new ModelAndView("index", "item", itemDao.findAll()); //foods is now a temp name for the list
		
	}
	
	
	@RequestMapping("/item")
	public ModelAndView cancel() {
		return new ModelAndView("redirect:/");
	}
	
	

		//path variable is required to identify which food we want to edit
	@RequestMapping("/item/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id")Long id) {
		ModelAndView mv = new ModelAndView("item-form");
		mv.addObject("title", "Edit item!"); //1st var is name we wanna call it
		mv.addObject("item", itemDao.findById(id).orElse(null)); //2nd is data we use over and over again
				
				return mv;
		
	}
	
	@PostMapping("/item/{id}/update")
	public ModelAndView submitEditForm(Item item) {
		//item.setId(id);
		itemDao.save(item);
		return new ModelAndView("redirect:/");
	}
	
	
	
	
	@RequestMapping("/item/{id}/delete")
	public ModelAndView delete(@PathVariable("id")long id) {
		itemDao.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	
	
	@RequestMapping("/item/add")
	public ModelAndView showAddForm() {
		ModelAndView mv = new ModelAndView("item-form");
		mv.addObject("title", "Add new item!"); //1st var is name we wanna call it
				
				return mv;
		
	}
	@PostMapping("/item/add")
	public ModelAndView submitAddForm(Item item) {
		//item.setId(id);
		itemDao.save(item);
		return new ModelAndView("redirect:/");
	}

}
