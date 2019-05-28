package com.app.crud.service;

import com.app.crud.dao.CityDAOHibernate;
import com.app.crud.entity.City;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CityService implements IService<City>{

    public CityDAOHibernate cityDAO;
    
	@Autowired
	public CityService(CityDAOHibernate cityDAO) {
		this.cityDAO = cityDAO;
	}
	
	@Transactional
    @Override
	public List<City> findAll() {
		return cityDAO.findAll();
	}

	@Transactional
    @Override
	public City findById(int id) {
        return null;
	}

	@Transactional
    @Override
	public void save(City city) {
	}

	@Transactional
    @Override
	public void deleteById(int id) {
	}

}






