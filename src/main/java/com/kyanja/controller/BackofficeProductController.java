package com.kyanja.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.kyanja.model.Product;
import com.kyanja.service.IProductService;
import org.springframework.util.StringUtils;



@Controller
@RequestMapping(value = "/admin")
public class BackofficeProductController {

	private static final Logger logger = LoggerFactory.getLogger(BackofficeProductController.class);

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView showForm( Model model) {
		model.addAttribute("categories", productService.listCategories());
		

		return new ModelAndView("addProduct", "product", new Product());
	}

	@RequestMapping(value = "/saveProd")
	public ModelAndView saveProd(@Valid Product product, BindingResult bindingResult, Model model, MultipartFile file)
			throws IOException {
		System.out.println("saveProd called=============================================");

		if (bindingResult.hasErrors()) {

			model.addAttribute("products", productService.findAllProduct());
			model.addAttribute("categories", productService.listCategories());
			System.out.println("list of categories called============================================="+productService.listCategories().toString());

			return new ModelAndView("redirect:/product/productlist");
		}

		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			product.setPhoto(file.getOriginalFilename());
			Integer idP = null;
			if (product.getId() == null) {
				idP = productService.addProduct(product);
			} else {
				productService.updateProduct(product);
				idP = product.getId();
			}
			file.transferTo(new File(path + "/" + "PROD_" + idP + "_" + file.getOriginalFilename()));
		} else {
			if (product.getId() == null)
				productService.addProduct(product);
			else
				productService.updateProduct(product);
		}
		model.addAttribute("product", new Product());
		model.addAttribute("products", productService.findAllProduct());
		

		return new ModelAndView("redirect:/product/productlist");
	}

	@RequestMapping(value = "photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Integer idProd) throws IOException {

		Product p = productService.findProductById(idProd);
		File f = new File(System.getProperty("java.io.tmpdir") + "/PROD_" + idProd + "_" + p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
	   Product newProduct = new Product();
	   model.addAttribute("newProduct", newProduct);
	   return "addProduct";
	}
	   
	
	

}
