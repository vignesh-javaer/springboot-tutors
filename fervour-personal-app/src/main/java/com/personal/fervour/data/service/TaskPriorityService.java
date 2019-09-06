/**
 * 
 */
package com.personal.fervour.data.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.personal.fervour.target.model.TaskPriority;

/**
 * @author vignesh
 *
 */
public interface TaskPriorityService {
	
	public TaskPriority addTask(TaskPriority task);
	public TaskPriority updateTask(TaskPriority task);
	public TaskPriority getTaskById(String userId,Long taskId);
	public Page<TaskPriority> getTask(String userId, Long taskId, Pageable page);
	public Page<TaskPriority> getTaskByStatus(String userId, String status, Pageable page);

}
