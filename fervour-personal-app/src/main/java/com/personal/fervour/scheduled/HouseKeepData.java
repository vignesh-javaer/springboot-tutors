/**
 * 
 */
package com.personal.fervour.scheduled;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author vignesh
 *
 */
@Component
@Slf4j
public class HouseKeepData {
	
	//@Scheduled(cron="*/5 * * * * *")
	public void scheduledClean() {
		
		log.info("Starting to housekeep");
		
	}
	
	
	

}
