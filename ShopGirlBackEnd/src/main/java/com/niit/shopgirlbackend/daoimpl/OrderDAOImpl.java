package com.niit.shopgirlbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shopgirlbackend.dao.OrderDAO;
import com.niit.shopgirlbackend.model.Order;

@Repository
public class OrderDAOImpl implements  OrderDAO {
	private static Logger log = LoggerFactory.getLogger(OrderDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public  OrderDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Order> list(String userID) {
		String hql = "from Order where userID=" + "'" + userID + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
     	@SuppressWarnings("unchecked")
		List<Order> list = (List<Order>) query.list();
			return list;
	}

	@Transactional
	public boolean saveOrUpdate(Order order) {
		log.debug("Starting of the method: saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(order);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			log.error("Not able to save or update record"+e.getMessage());
			e.printStackTrace();
		}
		log.debug("Starting of the method: saveOrUpdate");
		return true;
	}

	@Transactional
	public boolean delete(int orderID){
		log.debug("Starting of the method: delete");
		try {
			Order order = new Order();
			order.setOrderID(orderID);
			sessionFactory.getCurrentSession().delete(order);
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
	public Order get(String userID) {
		String hql = "from Order where userID=" + "'" + userID + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Order> list = (List<Order>) query.list();

		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}
}
