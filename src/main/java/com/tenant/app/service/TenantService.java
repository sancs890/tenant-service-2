package com.tenant.app.service;

import java.util.List;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenant.app.entity.DataSource;
import com.tenant.app.entity.Tenant;
import com.tenant.app.entity.TenantDTO;
import com.tenant.app.repository.DataSourceRepository;
import com.tenant.app.repository.TenantRepository;

@Service
public class TenantService {
	@Autowired
	private DataSourceRepository dsourceRepository;

	@Autowired
	private TenantRepository tenantRepository;

	@Autowired
	private Flyway flyway;

	@Transactional
	public void createTenant(TenantDTO tenantDTO) {
		DataSource dsource = new DataSource();
		dsource.setTenantId(tenantDTO.getInstanceName());
		dsource.setUsername("postgres");
		dsource.setPassword("password123");
		dsource.setUrl(
				"jdbc:postgresql://localhost:5432/postgres?useSSL=false&currentSchema=" + tenantDTO.getInstanceName());
		dsource.setDriverClassName("org.postgresql.Driver");
		dsourceRepository.save(dsource);

		Tenant tenant = new Tenant();
		tenant.setEmail(tenantDTO.getEmail());
		tenant.setOrgName(tenantDTO.getOrgName());
		tenant.setFirstName(tenantDTO.getFirstName());
		tenant.setLastName(tenantDTO.getLastName());
		tenant.setInstanceName(tenantDTO.getInstanceName());
		tenantRepository.save(tenant);

		Flyway fly = Flyway.configure()
				.configuration(flyway.getConfiguration())
				.schemas(tenantDTO.getInstanceName())
				.defaultSchema(tenantDTO.getInstanceName())
				.load();

		fly.migrate();
	}

	public List<DataSource> getAllDataSources() {
		return dsourceRepository.findAll();
	}
}
