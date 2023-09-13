package com.tenant.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tenant.app.entity.Tenant;

public class TenantEntityMapper implements RowMapper<Tenant> {
	public Tenant mapRow(ResultSet rs, int rowNum) throws SQLException {

		Tenant tenant = new Tenant();
		tenant.setId(rs.getInt("id"));
		tenant.setEmail(rs.getString("email"));
		tenant.setOrgName(rs.getString("orgName"));
		tenant.setFirstName(rs.getString("firstName"));
		tenant.setLastName(rs.getString("lastName"));
		tenant.setInstanceName(rs.getString("instanceName"));

		return tenant;
	}
}