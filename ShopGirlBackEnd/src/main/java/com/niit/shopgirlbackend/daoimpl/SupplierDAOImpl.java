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

import com.niit.shopgirlbackend.dao.SupplierDAO;
import com.niit.shopgirlbackend.model.Category;
import com.niit.shopgirlbackend.model.Supplier;


@Repository
public class SupplierDAOImpl implements SupplierDAO {
	
	Logger log = LoggerFactory.getLogger(SupplierDAOImpl.class);
	
	public SupplierDAOImpl(){
		
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Supplier> list() {
		log.debug("Starting of the method calliing list");
		String hql = "from Supplier";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method calling list");
		return query.list();
	}
	

	@Transactional
	public Supplier get(String id) {
		log.debug("start of the method : get");
		String hql = "from Supplier where id=" + "'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if(list != null && !list.isEmpty()){
			return list.get(0);	
		}
		log.debug("Ending of the method : get");
		return null;
		
	}
	
	@Transactional
	public Supplier getByName(String name){
		log.debug("Starting of the method: getByName");
		String hql = "from Supplier where name="+"'"+name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("Ending of the method : getByName");
		return (Supplier)query.uniqueResult();
	}
	
	
	@Transactional
	public boolean saveOrUpdate(Supplier supplier) {
		log.debug("Starting of the method: saveOrUpdate");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);
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
			Supplier supplier = new Supplier();
			supplier.setId(id);
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("Ending of the method: delete");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Not able to delete the record"+e.getMessage());
			e.printStackTrace();
			return false;
		}

	}
}

