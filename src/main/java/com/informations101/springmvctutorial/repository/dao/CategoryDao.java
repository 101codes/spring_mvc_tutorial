package com.informations101.springmvctutorial.repository.dao;

import java.util.List;

import com.informations101.springmvctutorial.repository.model.Category;

public interface CategoryDao {

	List<Category> findAllCategory();

	void insertCategory(Category category);

	void updateCategory(Category category);

	void executeUpdateCategory(Category category);

	void deleteCategory(Category category);
}
