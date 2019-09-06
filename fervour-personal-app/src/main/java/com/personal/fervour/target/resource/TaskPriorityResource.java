/**
 * 
 */
package com.personal.fervour.target.resource;

import java.net.URI;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.personal.fervour.cmm.response.ResponseEntityMapper;
import com.personal.fervour.cmm.response.ResponseType;
import com.personal.fervour.data.service.impl.TaskPriorityServiceImpl;
import com.personal.fervour.target.model.TaskPriority;

/**
 * @author vignesh
 *
 */
@RestController
@RequestMapping("/tasks")
public class TaskPriorityResource implements ResponseEntityMapper<TaskPriority>{
	
	@Autowired private MessageSource messageSource;
	
	@Autowired private TaskPriorityServiceImpl taskPriority;
	
	@GetMapping("/{userId}/welcomeMsg")
	public String getRequestMessage(@RequestHeader(name=HttpHeaders.ACCEPT_LANGUAGE,required=false) 
									final Locale locale, @PathVariable(name="userId") final String id) {
		String messageSrc = messageSource.getMessage("hello.welcome", null, locale);
		String message = String.format(messageSrc, id);
		return message;
	}
	
	
	@PostMapping("/user/{id}/add")
	public ResponseEntity<TaskPriority> addTask(@PathVariable("name") final String name, 
						@RequestBody final TaskPriority task) {
		final TaskPriority addTask = taskPriority.addTask(task);
		final URI location = ServletUriComponentsBuilder.fromCurrentRequest()
											 .path("{id}")
											 .buildAndExpand(task.getTaskId())
											 .toUri();
		final ResponseEntity<TaskPriority> response = 
				this.getResponse(ResponseType.ADD, addTask, location, null);
		return response;
	}
	
	

}
