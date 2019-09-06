/**
 * 
 */
package com.personal.fervour.data.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.personal.fervour.target.model.TaskPriority;
import com.personal.fervour.target.model.TaskPriorityId;


/**
 * @author vignesh
 *
 */
@Repository
public interface TaskProrityDao extends CrudRepository<TaskPriority, TaskPriorityId>, 
										JpaRepository<TaskPriority, TaskPriorityId> {
	
//	@Query("SELECT count(t) FROM TaskPriority t WHERE t.userId=:userId and t.status=:status")
//	public int countTaskByStatus(@Param("userId") String userId, 
//									@Param("status") String status);

	@Query("SELECT t FROM TaskPriority t WHERE t.userId=:userId and t.status=:status")
	public Page<TaskPriority> getTaskByStatusWithPaginate(@Param("userId") String userId, 
												@Param("status") String status, 
												Pageable page);
	
//	@Query("SELECT count(t) FROM TaskPriority t WHERE t.userId=:userId and t.taskId=:taskId")
//	public int countTask(@Param("userId") String userId, 
//						 @Param("taskId") Long taskId);
	
	@Query("SELECT t FROM TaskPriority t WHERE t.userId=:userId and t.taskId=:taskId")
	public Page<TaskPriority> getTaskWithPaginate(@Param("userId") String userId, 
										@Param("taskId") Long taskId, 
										Pageable page);
}
