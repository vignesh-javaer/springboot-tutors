/**
 * 
 */
package com.fervour.datasource.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

/**
 * @author vignesh
 *
 */
@Entity
@Table(name = "customer")
@Data
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int customerId;

	@Column(name = "name")
	private String customerName;

	@Column(name = "birth_date")
	private String customerDob;

	@Column(name = "id_type")
	private int customerIdType;

	@Column(name = "national_id")
	private String customerNationalId;

//	@OneToOne
//	@Column(name = "customer_id")
//	private CustomerAddress customerAddress;

}
