package com.tenant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.tenant.app.entity.Tenant;

@Transactional
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
	Tenant findByInstanceName(String instanceName);
}
