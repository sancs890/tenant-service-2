package com.tenant.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tenant.app.entity.DataSource;

public class DsourceMapper implements RowMapper<DataSource> {
	public DataSource mapRow(ResultSet rs, int rowNum) throws SQLException {

		DataSource dsource = new DataSource();
		dsource.setId(rs.getInt("id"));
		dsource.setTenantId(rs.getString("tenantId"));
		dsource.setUrl(rs.getString("url"));
		dsource.setUsername(rs.getString("username"));
		dsource.setPassword(rs.getString("password"));
		dsource.setDriverClassName(rs.getString("driverClassName"));

		return dsource;
	}
}