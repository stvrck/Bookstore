package swd20.hh.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import swd20.hh.bookstore.domain.Category;
import swd20.hh.bookstore.domain.CategoryRepository;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;

	@RequestMapping(value = "/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", repository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory")
	public String save(Category category) {
		repository.save(category);
		return "redirect:categorylist";
	}

}
