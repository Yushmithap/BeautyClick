package com.niit.shopgirlbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopgirlbackend.dao.CategoryDAO;
import com.niit.shopgirlbackend.model.Category;



@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	public CategoryDAOImpl(){
		
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Category> list() {
		logger.debug("Starting of the method calliing list");
		String hql = "from Category";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		logger.debug("Ending of the method calling list");
		return query.list();

	}
	
	
	@Transactional
	public Category get(String id) {
		logger.debug("start of the method : get");
		String hql = "from Category where id=" + "'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> list = (List<Category>) query.list();
		
		if(list != null && !list.isEmpty()){
			return list.get(0);	
		}
		logger.debug("Ending of the method : get");
		return null;
		
	}
	
	@Transactional
	public Category getByName(String name){
		logger.debug("Starting of the method: getUserByName");
		String hql = "from Category where name="+"'"+name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		logger.debug("Ending of the method : getUserByName");
		return (Category)query.uniqueResult();
	}
	
	@Transactional
	public boolean saveOrUpdate(Category category) {
		logger.debug("Starting of the method: saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			logger.error("Not able to save or update record"+e.getMessage());
			e.printStackTrace();
		}
		logger.debug("Starting of the method: saveOrUpdate");
		return true;
	}
	
	@Transactional
	public boolean delete(String id){
		logger.debug("Starting of the method: delete");
		try {
			Category category = new Category();
			category.setId(id);
			sessionFactory.getCurrentSession().delete(category);
			logger.debug("Ending of the method: delete");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			logger.error("Not able to delete the record"+e.getMessage());
			e.printStackTrace();
			return false;
		}

	}
}