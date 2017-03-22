package com.niit.shopgirlbackend.daoimpl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopgirlbackend.dao.CartDAO;
import com.niit.shopgirlbackend.model.Cart;




@Repository
public class CartDAOImpl implements CartDAO {
	private static Logger log = LoggerFactory.getLogger(CartDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl() {

	}

	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	@Transactional
	public List<Cart> list(String userID) {
		log.debug("Starting of the method list");
		String hql = "from Cart where userID=" + "'" + userID + "'  and status = " + "'NEW'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method list");
		return query.list();

	}

	

	@Transactional
	public boolean saveOrUpdate(Cart cart) {
		log.debug("Starting of the method: saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("Not able to save or update record"+e.getMessage());
			e.printStackTrace();
		}
		log.debug("Starting of the method: saveOrUpdate");
		return true;
	}
	
	@Transactional
	public boolean delete(int id){
		log.debug("Starting of the method: delete");
		try {
			Cart cart = new Cart();
			cart.setId(id);
			sessionFactory.getCurrentSession().delete(cart);
			log.debug("Ending of the method: delete");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Not able to delete the record"+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	
	@Transactional
	public Double getTotalAmount(String userID) {
		log.debug("Starting of the method getTotalAmount");
		String hql = "select sum(price) from Cart where userID=" + "'" + userID + "' " + "  and status = " + "'NEW'";
		log.debug("hql" + hql);

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method getTotalAmount");
		return (Double) query.uniqueResult();

	}
	
	
}


