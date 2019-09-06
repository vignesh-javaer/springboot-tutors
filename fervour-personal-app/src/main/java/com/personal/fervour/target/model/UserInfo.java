package com.personal.fervour.target.model;

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
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name="USER_INFO")
@JsonIgnoreProperties(value= {"createDate","lastUpdateDate","lastLoginDate","pke","status","hibernateLazyInitializer"},allowSetters=true)
@Getter @Setter
@ToString
public class UserInfo 
				extends ResourceSupport 
				implements Serializable{
	
	private static final long serialVersionUID = 7942317023479989029L;
	
	@Id
	@Column(name="USER_ID")
	@Pattern(regexp="^$|[a-zA-Z0-9_.]*")
	@Size(min=5, max=20)
	@NotNull
	private String userId;
	
	@Column(name="FIRST_NAME")
	@NotNull
	private String firstName;
	
	@Column(name="LAST_NAME")
	@NotNull
	private String lastName;
	
	@Column(name="EMAIL", unique=true)
	@NotNull
	@Email
	private String email;
	
	@Column(name="MOBILE", unique=true)
	@NotNull
	@Pattern(regexp="^$|[0-9]{10}")
	private String mobile;
	
	@Column(name="PKE")
	@NotBlank
	private String pke;
	
	@Past
	@Column(name="BIRTH_DATE")
	@JsonFormat(shape= Shape.STRING, pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date birthDate;
	
	@Column(name="STATUS")
	@NotNull
	private String status = "ACTIVE";
	
	
	@Column(name="CREATE_DATE")
	@CreationTimestamp
	private Date createDate;

	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;
	
	@Column(name="LAST_LOGIN_DATE")
	@UpdateTimestamp
	private Date lastLoginDate;
	
	

}
