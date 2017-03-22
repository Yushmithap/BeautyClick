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

import com.niit.shopgirlbackend.dao.UserDAO;
import com.niit.shopgirlbackend.model.User;



@Repository
public  class UserDAOImpl implements UserDAO {
	//creating a session so that connection loads and all hibernate configurations loads so that I can write HQL.
	Logger log = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(){
		
	}
	
	public UserDAOImpl(SessionFactory sessionFactory){	
			this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<User> list() {
		log.debug("Starting of the method list");
		String hql="from User";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of method list");
		return query.list();		
	}
	//if the valid id --> will return domain object
	//if the invalid id --> will return null
	
	@Transactional
	public User get(String id) {
		log.debug("start of the method : get");
		String hql = "from User where id=" + "'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		
		if(list != null && !list.isEmpty()){
			return list.get(0);	
		}
		log.debug("Ending of the method: getByName");
		return null;
	}
	
	@Transactional
	public User getByName(String name){
		log.debug("Starting of the method: getByName");
		String hql = "from User where name="+"'"+name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method: getByName");
		return (User)query.uniqueResult();
	}
	
	
	@Transactional
	public User isValidUser(String id, String password) {
		log.debug("Starting of the method: isValidUser");
		log.info("The user id:"+id);
		String hql="from User where id='" + id + "'and password='" +password+ "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.info("The query is:"+hql);
		log.debug("Ending of the method: isValidUser");
		return (User)query.uniqueResult();	
		
	}
	
		
	@Transactional
	public boolean saveOrUpdate(User user){
		log.debug("Starting of the method: saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("Not able to save or update record"+e.getMessage());
			e.printStackTrace();
		}
		log.debug("Starting of the method: saveOrUpdate");
		return true;

	}
	
	@Transactional
	public boolean delete(String id){
		log.debug("Starting of the method: delete");
		try {
			User user = new User();
			user.setId(id);
			sessionFactory.getCurrentSession().delete(user);
			log.debug("Ending of the method: delete");
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("Not able to delete the record"+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
}