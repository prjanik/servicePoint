package com.app.crud.service;

import com.app.crud.dao.CountryDAOHibernate;
import com.app.crud.entity.Country;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CountryService implements IService<Country>{

    public CountryDAOHibernate countryDAO;
    
	@Autowired
	public CountryService(CountryDAOHibernate countryDAO) {
		this.countryDAO = countryDAO;
	}
	
	@Transactional
    @Override
	public List<Country> findAll() {
		return countryDAO.findAll();
	}

    @Transactional
    @Override
	public Country findById(int id) {
        return null;
	}

	@Transactional
    @Override
	public void save(Country country) {
	}

	@Transactional
    @Override
	public void deleteById(int id) {
	}
}






