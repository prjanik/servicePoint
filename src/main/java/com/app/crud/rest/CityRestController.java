package com.app.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.entity.City;
import com.app.crud.service.CityService;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

	private CityService cityService;
	
	@Autowired
	public CityRestController(CityService cityServiceImpl) {
		cityService = cityServiceImpl;
	}
	
	@GetMapping("/cities")
	public List<City> findAll() {
		return cityService.findAll();
	}
}










