package com.informations101.springmvctutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informations101.springmvctutorial.repository.dao.CategoryDao;
import com.informations101.springmvctutorial.repository.implementdao.CategoryDaoImpl;
import com.informations101.springmvctutorial.repository.model.Category;

@Service
public class CategoryService implements CategoryDao{
	
	private CategoryDaoImpl categorydaoImpl;
	
	@Autowired
	public CategoryService(CategoryDaoImpl categorydaoImpl) {
		super();
		this.categorydaoImpl = categorydaoImpl;
	}

	@Override
	public List<Category> findAllCategory() {
		if(categorydaoImpl.findAllCategory().isEmpty()) {
//			
		}
		return categorydaoImpl.findAllCategory();
	}

	@Override
	public void insertCategory(Category category) {
		this.categorydaoImpl.insertCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void executeUpdateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(Category category) {
		categorydaoImpl.deleteCategory(category);
	}

}
