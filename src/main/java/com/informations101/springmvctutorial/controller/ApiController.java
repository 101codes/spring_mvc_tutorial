package com.informations101.springmvctutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.informations101.springmvctutorial.repository.model.Category;
import com.informations101.springmvctutorial.service.CategoryService;

@RestController
@RequestMapping(value = "/v1")
public class ApiController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "/category-list")
	List<Category> getCategories() {
		return categoryService.findAllCategory();
	}

	@PostMapping(value = "/create-category")
	void createCategory(@RequestBody Category category) {
		categoryService.insertCategory(category);
	}
	@DeleteMapping(value = "delete-category")
	void deleteCategory(@RequestBody Category category) {
		categoryService.deleteCategory(category);
	}
}
