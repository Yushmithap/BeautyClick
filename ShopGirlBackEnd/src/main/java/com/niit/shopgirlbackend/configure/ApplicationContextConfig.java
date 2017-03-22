package com.niit.shopgirlbackend.configure;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shopgirlbackend.model.BillingAddress;
import com.niit.shopgirlbackend.model.Cart;
import com.niit.shopgirlbackend.model.Category;
import com.niit.shopgirlbackend.model.Order;
import com.niit.shopgirlbackend.model.PaymentMethod;
import com.niit.shopgirlbackend.model.Product;
import com.niit.shopgirlbackend.model.ShippingAddress;
import com.niit.shopgirlbackend.model.Supplier;
import com.niit.shopgirlbackend.model.User;

@Configuration
@ComponentScan("com.niit.shopgirlbackend")
@EnableTransactionManagement

public class ApplicationContextConfig {


	 	
	 	
	 	
	 	@Bean(name= "dataSource")
	     public DataSource getDataSource() 
	 	{
	         DriverManagerDataSource dataSource = new DriverManagerDataSource();
	         dataSource.setDriverClassName("org.h2.Driver");
	         dataSource.setUrl(" jdbc:h2:tcp://localhost/~/test");
	         dataSource.setUsername("sa");
	         dataSource.setPassword("");
	         return dataSource;
	     }
	  
	  
	  public Properties getHibernateProperties(){
	         Properties properties = new Properties();
	         properties.put("hibernate.show_sql", "true");
	         properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	         properties.put("hibernate.hbm2ddl.auto", "update");
	         return properties;        
	     }
	  
	  	@Autowired
	     @Bean(name= "sessionFactory")
	     public SessionFactory getSessionFactory(DataSource dataSource)
	  	{
	         LocalSessionFactoryBuilder sessionBuilder= new LocalSessionFactoryBuilder(dataSource);
	         sessionBuilder.addProperties(getHibernateProperties());
	         
	         sessionBuilder.addAnnotatedClass(User.class);
	         sessionBuilder.addAnnotatedClass(Supplier.class);
	         sessionBuilder.addAnnotatedClass(Category.class);
	         sessionBuilder.addAnnotatedClass(Product.class);
	         sessionBuilder.addAnnotatedClass(Cart.class);
	         sessionBuilder.addAnnotatedClass(Order.class);
	    
	        return sessionBuilder.buildSessionFactory();
	  	
	 }
	     
	      
	     
	  	@Autowired 
	     @Bean(name= "transactionManager")
	     public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	        return transactionManager;

	 }
	 }


