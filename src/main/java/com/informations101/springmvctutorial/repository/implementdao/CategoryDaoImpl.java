package com.informations101.springmvctutorial.repository.implementdao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.informations101.springmvctutorial.repository.dao.CategoryDao;
import com.informations101.springmvctutorial.repository.implementdao.rowmaper.CategoryRowMaper;
import com.informations101.springmvctutorial.repository.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	NamedParameterJdbcTemplate template;

	public CategoryDaoImpl(NamedParameterJdbcTemplate template) {
		super();
		this.template = template;
	}

	@Override
	public List<Category> findAllCategory() {
		return template.query("SELECT * FROM \"MBBS_CATEGORY\";", new CategoryRowMaper());
	}

	@Override
	public void insertCategory(Category cat) {
		final String sql = "INSERT INTO  \"MBBS_CATEGORY\" (category_code, category_name, category_desc) VALUES(:categoryCode, :categoryName, :categoryDesc);";
		KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
			.addValue("categoryCode", cat.getCategoryCode())
			.addValue("categoryName", cat.getCategoryName())
			.addValue("categoryDesc", cat.getCategoryDesc());
        template.update(sql,param, holder);
	}

	@Override
	public void updateCategory(Category cat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executeUpdateCategory(Category cat) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCategory(Category cat) {
		// TODO Auto-generated method stub

	}

}
