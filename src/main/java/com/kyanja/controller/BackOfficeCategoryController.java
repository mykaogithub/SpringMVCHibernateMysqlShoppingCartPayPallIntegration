package com.kyanja.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kyanja.model.Category;
import com.kyanja.service.IProductService;


@Controller
@RequestMapping(value = "admin")
public class BackOfficeCategoryController implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(BackOfficeCategoryController.class);

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("addCategory", "category", new Category());
	}

	@RequestMapping(value = "/saveCategory")
	public ModelAndView saveCategory(@Valid Category category, BindingResult bindingResult, Model model)
			throws IOException {
		System.out.println("saveCategory called=============================================");

		if (bindingResult.hasErrors()) {

			model.addAttribute("products", productService.findAllProduct());
			return new ModelAndView("redirect:/product/productlist");
		}

		if (category.getId() != null) {

			Category cat = productService.getCategoryById(category.getId());

			productService.updateCategory(cat);
		} else

			productService.addCategory(category);

		model.addAttribute("category", new Category());
		model.addAttribute("categories", productService.listCategories());
		
		System.out.println("categories list called============================================="+ productService.listCategories().toString());

		model.addAttribute("products", productService.findAllProduct());

		return new ModelAndView("redirect:/product/productlist");
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("category", new Category());
		mv.addObject("categories",productService.listCategories());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}

}
