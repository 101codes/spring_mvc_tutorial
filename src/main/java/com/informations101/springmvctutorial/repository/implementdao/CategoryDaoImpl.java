package com.informations101.springmvctutorial.repository.implementdao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
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
	public void insertCategory(Category category) {
		final String sql = "INSERT INTO  \"MBBS_CATEGORY\" (category_code, category_name, category_desc) VALUES(:categoryCode, :categoryName, :categoryDesc);";
		KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
			.addValue("categoryCode", category.getCategoryCode())
			.addValue("categoryName", category.getCategoryName())
			.addValue("categoryDesc", category.getCategoryDesc());
        template.update(sql,param, holder);
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
		final String sql= "DELETE FROM \"MBBS_CATEGORY\" WHERE category_code = :cateogryCode";

		 Map<String,Object> map=new HashMap<String,Object>();  
		 map.put("cateogryCode", category.getCategoryCode());
		 template.execute(sql,map,new PreparedStatementCallback<Object>() {  
		    @Override  
		    public Object doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException {  
		        return ps.executeUpdate();  
		    }  
		});

	}

}
