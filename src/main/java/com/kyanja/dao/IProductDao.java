package com.kyanja.dao;

import java.util.List;

import com.kyanja.model.Category;
import com.kyanja.model.Product;

public interface IProductDao {

	List<Product> findAllProduct();

	Integer addProduct(Product p);

	void updateProduct(Product p);

	void deleteProduct(Integer id);

	Product findProductById(Integer id);

	Long addCategory(Category c);

	List<Category> listCategories();

	Category getCategoryById(Long idCat);

	void removeCategrory(Long idcat);

	void updateCategory(Category c);

	Integer saveProductByCategory(Product p, Long idCat);

}
