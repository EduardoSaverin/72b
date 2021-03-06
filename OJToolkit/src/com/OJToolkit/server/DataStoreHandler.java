package com.OJToolkit.server;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import com.OJToolkit.client.Exceptions.NotLoggedInException;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class DataStoreHandler {

	public static final PersistenceManagerFactory PMF = JDOHelper
	        .getPersistenceManagerFactory("transactions-optional");

	static PersistenceManager pm;

	public DataStoreHandler() {

	}

	/**
	 * @return list of coders 
	 */
	public static List<Coder> getAllCoders() { 
		pm = getPersistenceManager();
		String select_query = "select from " + Coder.class.getName();
		Query query = pm.newQuery(select_query);
		query.setFilter("email == userEmail");
		query.declareParameters("java.lang.String userEmail");
		List<Coder> coders = (List<Coder>) query.execute(getUser().getEmail());
		return coders;
	}

	/**
	 * @throws NotLoggedInException
	 */
	static void checkLoggedIn() throws NotLoggedInException {
		if (getUser() == null) {
			throw new NotLoggedInException("Not logged in.");
		}
	}

	/**
	 * @return user 
	 */
	static User getUser() {
		UserService userService = UserServiceFactory.getUserService();
		User u = userService.getCurrentUser() ;  
		return u ;
	}

	static PersistenceManager getPersistenceManager() {
		return PMF.getPersistenceManager();
	}

}
