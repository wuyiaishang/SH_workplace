package com.spring.web.tutorial.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {

	// private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;
   
	public OffersDAO(){
		System.out.println("load the offerdao");
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Offer> getOffers() {

		return jdbc.query("SELECT * FROM OFFERS", new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int num) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				
				return offer;
			}

		});

	}
	
	public boolean update( Offer offer ){
BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		
		if( jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id", param) == 1)  // the strings behind colons should be same with the property name of the offer class
		    return true;
		else 
			return false;
	}
	
@Transactional
	public int[] create( List<Offer> list ){
		SqlParameterSource[] param = SqlParameterSourceUtils.createBatch(list.toArray());
		
		//jdbc.getJdbcOperations().batchUpdate("")   for no parameter for batch updates
		
		return jdbc.batchUpdate("insert into offers (id, name, email, text) values(:id, :name, :email, :text)", param);
	}
	
	public boolean create( Offer offer ){
		
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		
		if( jdbc.update("insert into offers (name, email, text) values(:name, :email, :text)", param) == 1)  // the strings behind colons should be same with the property name of the offer class
		    return true;
		else 
			return false;
	}
	
	public boolean delete( int id ){
		
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		
		return jdbc.update("DELETE FROM OFFERS WHERE ID=:id", param)==1;
	}

	public Offer getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		// could add more parameters

		return jdbc.queryForObject("SELECT * FROM OFFERS WHERE ID=:id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int num) throws SQLException {
				Offer offer = new Offer();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));
				return offer;
			}

		});

	
	}

	
}
