package swd20.hh.bookstore.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	 @RequestMapping(value="/categories", method = RequestMethod.GET)
	    public @ResponseBody List<Category> getCategoriesRest() {	
	        return (List<Category>) repository.findAll();
	    }
	 
	  @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {	
	    	return repository.findById(categoryId);
	    } 
	  
	  
	  @RequestMapping(value="/categories", method = RequestMethod.POST)
	    public @ResponseBody Category saveCategoryRest(@RequestBody Category category) {	
	    	return repository.save(category);
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
