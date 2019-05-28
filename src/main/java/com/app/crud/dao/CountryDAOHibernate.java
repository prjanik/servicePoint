package com.app.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.crud.entity.Country;

@Repository
public class CountryDAOHibernate extends DAO<Country> {

	@Autowired
	public CountryDAOHibernate(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	@Override
	public List<Country> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Country> theQuery =
				currentSession.createQuery("from Country", Country.class);
		
		List<Country> cities = theQuery.getResultList();
		
		return cities;
	}
}







