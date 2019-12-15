package com.informations101.springmvctutorial.repository.implementdao.rowmaper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.informations101.springmvctutorial.repository.model.Category;

public class CategoryRowMaper implements RowMapper<Category>{

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category cat = new Category();
		cat.setCategoryCode(rs.getString("category_code"));
		cat.setCategoryName(rs.getString("category_name"));
		cat.setCategoryDesc(rs.getString("category_desc"));
		return cat;
	}

}
