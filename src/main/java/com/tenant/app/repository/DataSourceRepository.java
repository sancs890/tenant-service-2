package com.tenant.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.tenant.app.entity.DataSource;

@Transactional
public interface DataSourceRepository extends JpaRepository<DataSource, Integer> {

}
