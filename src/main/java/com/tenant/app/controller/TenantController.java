package com.tenant.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tenant.app.entity.DataSource;
import com.tenant.app.entity.TenantDTO;
import com.tenant.app.response.MessageResponse;
import com.tenant.app.service.TenantService;

@RestController
@RequestMapping("/api/v1/tenant")
public class TenantController {

	@Autowired
	TenantService tenantService;

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<Object> addDSource(@RequestBody TenantDTO tenantDTO) {
		tenantService.createTenant(tenantDTO);
		return new ResponseEntity<>(new MessageResponse("Tenant registered successfully!"), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/getAll")
	public List<DataSource> getAll() {
		return tenantService.getAllDataSources();
	}
}
