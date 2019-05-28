package com.app.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.crud.entity.Point;

@Repository
public class PointDAOHibernate extends DAO<Point> {

	@Autowired
	public PointDAOHibernate(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Point> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Point> theQuery =
				currentSession.createQuery("from Point", Point.class);
		
		List<Point> points = theQuery.getResultList();
		
		return points;
	}


	@Override
	public Point findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Point theCity =
				currentSession.get(Point.class, theId);
		
		return theCity;
	}


	@Override
	public void save(Point point) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(point);
	}


	@Override
	public void deleteById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
				
		Query theQuery = 
				currentSession.createQuery(
						"delete from Point where id=:pointId");
		theQuery.setParameter("pointId", id);
		
		theQuery.executeUpdate();
	}

}







