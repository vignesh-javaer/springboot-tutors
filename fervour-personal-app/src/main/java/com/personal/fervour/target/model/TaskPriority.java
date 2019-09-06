/**
 * 
 */
package com.personal.fervour.target.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author vignesh
 *
 */
@Entity
@Table(name="TASK_PRIORITY")
@IdClass(TaskPriorityId.class)
@Getter @Setter
@ToString
public class TaskPriority implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -7928005723641729587L;
	
	@Id
	@Column(name="USER_ID")
	private String userId;
	
	@Id
	@SequenceGenerator(name = "taskid")
	@Column(name="TASK_ID")
	private Long taskId;
	
	@Size(min=5, max=255, message="size of title should be within 5 - 255 of characters")
	@Column(name="TITLE",unique=true)
	private String title;
	
	@Column(name="PRIORITY")
	private String priority;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PERCENTAGE")
	private Integer percentage;
	
	@CreationTimestamp
	@Column(name="CREATE_DT")
	private Date createDate;
	
	@Column(name="DUE_DT")
	private Date dueDate;
	
	@Column(name="ASSIGNED_BY")
	private String assigne;
	
	@Column(name="LAST_UPDATE_USER")
	private String lastUpdatedBy;
	
	@UpdateTimestamp
	@Column(name="LAST_UPDATE_DT")
	private Date lastUpdateDate;
	

}
