package com.informations101.springmvctutorial.repository.dao;

import java.util.List;

import com.informations101.springmvctutorial.repository.model.Category;

public interface CategoryDao {

	List<Category> findAllCategory();

	void insertCategory(Category cat);

	void updateCategory(Category cat);

	void executeUpdateCategory(Category cat);

	void deleteCategory(Category cat);
}
