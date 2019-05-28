package com.app.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.crud.entity.Country;
import com.app.crud.service.CountryService;

@RestController
@RequestMapping("/api/country")
public class CountryRestController {

	private CountryService countryService;
	
	@Autowired
	public CountryRestController(CountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping("/countries")
	public List<Country> findAll() {
		return countryService.findAll();
	}
	
}










