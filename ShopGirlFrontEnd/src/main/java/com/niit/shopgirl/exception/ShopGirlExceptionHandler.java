package com.niit.shopgirl.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ShopGirlExceptionHandler {
	
private static Logger logger = LoggerFactory.getLogger(ShopGirlExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception e){
		logger.error("SQL Exception Occured :: URL = "+request.getRequestURL());
		logger.error("SQL Exception Occured:: Exception=" +e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message" , "One of the tabel or few fields does not exist in DB, See the table and fields created");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
		}
	
	@ExceptionHandler(CannotCreateTransactionException.class)
	public ModelAndView dbServerNotStarted(HttpServletRequest request, Exception e){
		logger.error("SQL Exception Occured :: URL = "+request.getRequestURL());
		logger.error("SQL Exception Occured:: Exception=" +e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message" , " Please start the database server");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
		
	}
	
	@ExceptionHandler(QuerySyntaxException.class)
	public ModelAndView handleQuerySyntaxException(HttpServletRequest request, Exception e){
		logger.error("Query Syntax Exception Occured :: URL = "+request.getRequestURL());
		logger.error("Query Syntax Exception Occured:: Exception=" +e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message" , "  One of the query is not proper.....look at the logger for more information");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandlerException(HttpServletRequest request, Exception e){
		logger.error("NoHandlerException Occured :: URL = "+request.getRequestURL());
		logger.error("NoHandlerException Occured:: Exception=" +e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message" , "No Handler found Invalid URL ....Look for logger for more information");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(HttpServletRequest request, Exception e){
		logger.error("IOException handler executed");
		logger.error("IOException Occured:: Exception=" +e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("message" , "Cannot connect to server , Please contact administrator");
		mv.addObject("errorMessage", e.getMessage());
		return mv;
	}
	
	
	
	
	

}
