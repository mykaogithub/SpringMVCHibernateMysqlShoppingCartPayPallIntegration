package com.kyanja.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kyanja.model.Product;
import com.kyanja.service.IProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	
	
	
	@Autowired
	private IProductService productService;



	@RequestMapping(value="/productlist",method = RequestMethod.GET)
	public String index(Model model){
		
		 model.addAttribute("listproduct",new Product());
		 model.addAttribute("listproduct",productService.findAllProduct());
		 model.addAttribute("categories", productService.listCategories());
		
        return "home";
	}
	
	@RequestMapping(value="photoProd",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Integer idProd) throws IOException{
        Product p= productService.findProductById(idProd);
        File f=new File(System.getProperty("java.io.tmpdir")+"/PROD_"+idProd+"_"+p.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	@RequestMapping("/details")
	public String getProductById(@RequestParam("id") Integer productId, Model model) {
	   model.addAttribute("product", productService.findProductById(productId));
	   return "product";
	}
}