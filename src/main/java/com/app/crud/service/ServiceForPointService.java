package com.app.crud.service;

import com.app.crud.dao.ServiceDAOHibernate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceForPointService implements IService<com.app.crud.entity.Service> {

    public ServiceDAOHibernate serviceDAO;
    
	@Autowired
	public ServiceForPointService(ServiceDAOHibernate serviceDAO) {
		this.serviceDAO = serviceDAO;
	}
	
	@Transactional
    @Override
	public List<com.app.crud.entity.Service> findAll() {
		return serviceDAO.findAll();
	}

    @Transactional
    @Override
	public com.app.crud.entity.Service findById(int id) {
        return null;
	}

	@Transactional
    @Override
	public void save(com.app.crud.entity.Service service) {
	}

	@Transactional
    @Override
	public void deleteById(int id) {
	}
}






