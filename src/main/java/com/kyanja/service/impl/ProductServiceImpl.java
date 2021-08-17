package com.kyanja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kyanja.dao.IProductDao;
import com.kyanja.model.Category;
import com.kyanja.model.Product;
import com.kyanja.service.IProductService;


@Service
@Transactional
public class ProductServiceImpl implements IProductService{
	
	
	@Autowired
	private IProductDao dao;

	public List<Product> findAllProduct() {
	
		return dao.findAllProduct();
	}

	public Integer addProduct(Product p) {

		
		return dao.addProduct(p);
		
	}

	public void updateProduct(Product p) {

		dao.updateProduct(p);
		
	}

	public void deleteProduct(Integer id) {
	
		dao.deleteProduct(id);
		
	}

	public Product findProductById(Integer id) {
		
		return dao.findProductById(id);
	}

	@Override
	public Long addCategory(Category c) {
		
		return dao.addCategory(c);
	}

	@Override
	public List<Category> listCategories() {
	
		return dao.listCategories();
	}

	@Override
	public Category getCategoryById(Long idCat) {
	
		return dao.getCategoryById(idCat);
	}

	@Override
	public void removeCategrory(Long idcat) {
	
		dao.removeCategrory(idcat);
	}

	@Override
	public void updateCategory(Category c) {
		
		dao.updateCategory(c);
		
	}

	@Override
	public Integer saveProductByCategory(Product p, Long idCat) {
	
		return dao.saveProductByCategory(p, idCat);
	}

	

}
