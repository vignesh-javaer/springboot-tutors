/**
 * 
 */
package com.fervour.datasource.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.fervour.datasource.entity.Customer;

/**
 * @author vignesh
 *
 */
@Repository
public class CutomerUpdateDao {

	@PersistenceContext
	private EntityManager entityMgr;

	public List<Customer> findAllCustomer() {
		// 1. create criteria builder 
		final CriteriaBuilder cb = entityMgr.getCriteriaBuilder();
		
		// 2. create a query to communicate the customer table.
		CriteriaQuery<Customer> createQuery = cb.createQuery(Customer.class);
		
		// 3. use FROM to get result set from interested table.
		Root<Customer> from = createQuery.from(Customer.class);
		
		// 4. a.Optional - use multi colum select from the table.
		createQuery.multiselect(from.get("customerId"),from.get("customerNationalId"));
		
		// 4. b.Optional - order by clause. Used DESC.
		// select customer0_.id as id1_0_, customer0_.birth_date as birth_da2_0_, 
		// customer0_.id_type as id_type3_0_, customer0_.name as name4_0_, customer0_.national_id as national5_0_ 
		// from customer customer0_ order by customer0_.id desc
		createQuery.orderBy(cb.desc(from.get("customerId")));
		
		
		
		// 5. use action, ie if need to select the from clause.
		createQuery.select(from);
		
		// 6. use the entity manager to make a typed query.
		TypedQuery<Customer> query = entityMgr.createQuery(createQuery);
		
		// 7. get the result set.
		return query.getResultList();
	}
}
