package com.demo.jdbc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.jdbc.domain.DemoUser;
import com.demo.jdbc.domain.DemoUserRowMapper;
import com.demo.jdbc.domain.FieldType;

@Repository
public class DemoUserRepository {

	private static final Logger LOG = LoggerFactory.getLogger(DemoUserRepository.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public DemoUser getUser(String username) {
		try {
			String query = "SELECT username, password, firstname, lastname, email FROM demo_users WHERE username = :username";
			MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), username);
			return namedParameterJdbcTemplate.queryForObject(query, mapSqlParameterSource, new DemoUserRowMapper());
		} catch (Exception ex) {
			LOG.error("Exception in getUser() ", ex);
			return null;
		}
	}

	public void updateUser(DemoUser demoUser) {
		String query = "UPDATE demo_users SET firstname = :firstname, lastname = :lastname, email = :email, password = :password WHERE username = :username";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue(FieldType.FIRSTNAME.getValue(), demoUser.getFirstname());
		mapSqlParameterSource.addValue(FieldType.LASTNAME.getValue(), demoUser.getLastname());
		mapSqlParameterSource.addValue(FieldType.EMAIL.getValue(), demoUser.getEmail());
		mapSqlParameterSource.addValue(FieldType.PASSWORD.getValue(), demoUser.getPassword());
		mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), demoUser.getUsername());
		namedParameterJdbcTemplate.update(query, mapSqlParameterSource);
	}

	public void registerUser(DemoUser demoUser) {
		String query = "INSERT INTO demo_users (username, password, firstname, lastname, email) VALUES (:username, :password, :firstname, :lastname, :password)";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), demoUser.getUsername());
		mapSqlParameterSource.addValue(FieldType.PASSWORD.getValue(), demoUser.getPassword());
		mapSqlParameterSource.addValue(FieldType.FIRSTNAME.getValue(), demoUser.getFirstname());
		mapSqlParameterSource.addValue(FieldType.LASTNAME.getValue(), demoUser.getLastname());
		mapSqlParameterSource.addValue(FieldType.EMAIL.getValue(), demoUser.getEmail());
		namedParameterJdbcTemplate.update(query, mapSqlParameterSource);
	}

	public void deleteUser(String username) {
		String query = "DELETE FROM demo_users WHERE username = :username";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue(FieldType.USERNAME.getValue(), username);
		namedParameterJdbcTemplate.update(query, mapSqlParameterSource);
	}
}
