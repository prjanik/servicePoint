package com.app.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.crud.entity.Service;

@Repository
public class ServiceDAOHibernate extends DAO<Service> {

	@Autowired
	public ServiceDAOHibernate(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Service> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Service> theQuery =
				currentSession.createQuery("from Service", Service.class);
		
		List<Service> services = theQuery.getResultList();
		
		return services;
	}
}







