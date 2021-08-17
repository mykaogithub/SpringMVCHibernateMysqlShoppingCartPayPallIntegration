package com.kyanja.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kyanja.dao.IProductDao;
import com.kyanja.model.Category;
import com.kyanja.model.Product;

@Repository

public class ProductDaoImpl implements IProductDao {

	@Autowired
	private SessionFactory sf;

	public List<Product> findAllProduct() {

		List<Product> products = sf.getCurrentSession().createQuery("from Product").list();
		return products;
	}

	public Integer addProduct(Product p) {

		sf.getCurrentSession().saveOrUpdate(p);

		return p.getId();

	}

	public void updateProduct(Product p) {

		sf.getCurrentSession().update(p);

	}

	public void deleteProduct(Integer id) {

		Product product = (Product) sf.getCurrentSession().load(Product.class, id);

		if (product != null) {

			sf.getCurrentSession().delete(product);
		}

	}

	public Product findProductById(Integer id) {

		Product product = (Product) sf.getCurrentSession().get(Product.class, id);
		return product;
	}

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Long addCategory(Category c) {

		sf.getCurrentSession().saveOrUpdate(c);

		return c.getId();

	}

	@Override
	public List<Category> listCategories() {


		List<Category> categories = sf.getCurrentSession().createQuery("from Category").list();
		return categories;
	}

	@Override
	public Category getCategoryById(Long idCat) {
	
		return (Category) sf.getCurrentSession().load(Category.class, idCat);
	}

	@Override
	public void removeCategrory(Long idcat) {
		
		Category cat = (Category) sf.getCurrentSession().load(Category.class, idcat);
		
		if(cat !=null) {
			
			sf.getCurrentSession().delete(cat);
		}
	}

	@Override
	public void updateCategory(Category c) {
		
		sf.getCurrentSession().update(c);
	}

	@Override
	public Integer saveProductByCategory(Product p, Long idCat) {
		
		Category category = (Category) sf.getCurrentSession().load(Category.class, idCat);
		
		p.setCategory(category);
	
		sf.getCurrentSession().saveOrUpdate(p);

		return p.getId();
	}

}
