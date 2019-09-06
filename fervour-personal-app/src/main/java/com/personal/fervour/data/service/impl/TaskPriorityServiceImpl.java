/**
 * 
 */
package com.personal.fervour.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personal.fervour.data.dao.TaskProrityDao;
import com.personal.fervour.data.service.TaskPriorityService;
import com.personal.fervour.target.model.TaskPriority;
import com.personal.fervour.target.model.TaskPriorityId;

/**
 * @author vignesh
 *
 */
@Service
@Transactional
public class TaskPriorityServiceImpl implements TaskPriorityService {
	
	/*
	 * 
	 */
	@Autowired
	private TaskProrityDao taskPriorityRepo;
	
	/*
	 * (non-Javadoc)
	 * @see com.personal.fervour.data.service.TaskPriorityService#addTask(com.personal.fervour.target.model.TaskPriority)
	 */
	@Override
	public TaskPriority addTask(TaskPriority task) {
		return taskPriorityRepo.save(task);
	}

	/*
	 * (non-Javadoc)
	 * @see com.personal.fervour.data.service.TaskPriorityService#updateTask(com.personal.fervour.target.model.TaskPriority)
	 */
	@Override
	public TaskPriority updateTask(TaskPriority task) {
		return taskPriorityRepo.save(task);
	}

	/*
	 * (non-Javadoc)
	 * @see com.personal.fervour.data.service.TaskPriorityService#getTask(java.lang.String, java.lang.Long, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<TaskPriority> getTask(String userId, Long taskId, Pageable page) {
		return taskPriorityRepo.getTaskWithPaginate(userId, taskId, page);
	}

	/*
	 * (non-Javadoc)
	 * @see com.personal.fervour.data.service.TaskPriorityService#getTaskByStatus(java.lang.String, java.lang.String, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<TaskPriority> getTaskByStatus(String userId, String status, Pageable page) {
		return taskPriorityRepo.getTaskByStatusWithPaginate(userId, status, page);
	}

	/*
	 * (non-Javadoc)
	 * @see com.personal.fervour.data.service.TaskPriorityService#getTaskById(java.lang.String, java.lang.Long)
	 */
	@Override
	public TaskPriority getTaskById(String userId,Long taskId) {
		return taskPriorityRepo.getOne(new TaskPriorityId(userId, taskId));
	}

}
