package com.app.crud.rest;

import com.app.crud.entity.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.service.ServiceForPointService;

@RestController
@RequestMapping("/api/service")
public class ServiceRestController {

	private ServiceForPointService serviceForService;
	
	@Autowired
	public ServiceRestController(ServiceForPointService serviceForService) {
		this.serviceForService = serviceForService;
	}
	
	@GetMapping("/services")
	public List<Service> findAll() {
		return serviceForService.findAll();
	}
}










