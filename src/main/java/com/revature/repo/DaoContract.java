package com.revature.repo;

import java.util.List;

public interface DaoContract<T, I> {
	/**
	 * @return a list of all instances in the db
	 */
	
	 List<T> findAll();
	 
	 /**
	  * @param i primary key of the instance
	  * @return the instance with the same primary key
	  */
	 
	 

}
