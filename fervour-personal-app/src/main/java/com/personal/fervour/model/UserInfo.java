package com.personal.fervour.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.ResourceSupport;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="USER_INFO")
@Getter @Setter
@ToString
public class UserInfo 
				extends ResourceSupport 
				implements Serializable{
	
	private static final long serialVersionUID = 7942317023479989029L;
	
	@Id
	@Column(name="USER_ID")
	@NotBlank
	private String userId;
	
	@Column(name="FIRST_NAME")
	@NotBlank
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotBlank
	private String lastName;
	
	@Column(name="EMAIL")
	@NotBlank
	@Email
	private String email;
	
	@Column(name="MOBILE")
	@NotBlank
	@Pattern(regexp="^$|[0-9] {10}")
	private String mobile;
	
	@Column(name="PKE")
	@NotBlank
	private String pke;
	
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private Date createDate;

	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@Column(name="LAST_LOGIN_DATE")
	@UpdateTimestamp
	private Date lastLoginDate;
	
	@Column(name="STATUS")
	@NotNull
	private String status = "ACTIVE";
	
	@Column(name="BIRTH_DATE")
	@NotBlank
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	

}
