package com.personal.fervour.target.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class TaskPriorityId implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userId;
	private Long taskId;
	
	public TaskPriorityId() {}

	public TaskPriorityId(String userId, Long taskId) {
		this.userId = userId;
		this.taskId = taskId;
	}
	
	
}
