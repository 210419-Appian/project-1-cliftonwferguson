package com.revature.repo;

import java.util.List;

/**
 *
 * @param <T>
 * @param <I>
 * 
 *   This will create a contract
 */

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
