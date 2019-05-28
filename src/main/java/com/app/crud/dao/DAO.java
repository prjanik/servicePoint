package com.app.crud.dao;

import java.util.List;
import javax.persistence.EntityManager;

public abstract class DAO<T> {

    protected EntityManager entityManager;

	public abstract List<T> findAll();
	
	public T findById(int id) {
        return null;
    }
	
	public void save(T t) {}
	
	public void deleteById(int id){}
}
