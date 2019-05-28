package com.app.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.crud.entity.City;

@Repository
public class CityDAOHibernate extends DAO<City> {

	@Autowired
	public CityDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<City> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<City> theQuery =
				currentSession.createQuery("from City", City.class);
		
		List<City> cities = theQuery.getResultList();
		
		return cities;
	}
}







