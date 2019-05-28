package com.app.crud.service;

import com.app.crud.dao.PointDAOHibernate;
import com.app.crud.entity.Point;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PointService implements IService<Point>{

    public PointDAOHibernate pointDAO;
    
	@Autowired
	public PointService(PointDAOHibernate pointDAO) {
		this.pointDAO = pointDAO;
	}
	
	@Transactional
    @Override
	public List<Point> findAll() {
		return pointDAO.findAll();
	}

	@Transactional
    @Override
	public Point findById(int id) {
		return pointDAO.findById(id);
	}

	@Transactional
    @Override
	public void save(Point point) {
		pointDAO.save(point);
	}

	@Transactional
    @Override
	public void deleteById(int id) {
		pointDAO.deleteById(id);
	}

}






