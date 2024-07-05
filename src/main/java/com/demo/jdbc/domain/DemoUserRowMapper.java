package com.demo.jdbc.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DemoUserRowMapper implements RowMapper<DemoUser> {

    @Override
    public DemoUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        DemoUser demoUser = new DemoUser();
        demoUser.setUsername(rs.getString(FieldType.USERNAME.getValue()));
        demoUser.setPassword(rs.getString(FieldType.PASSWORD.getValue()));
        demoUser.setFirstname(rs.getString(FieldType.FIRSTNAME.getValue()));
        demoUser.setLastname(rs.getString(FieldType.LASTNAME.getValue()));
        demoUser.setEmail(rs.getString(FieldType.EMAIL.getValue()));
        return demoUser;
    }
}