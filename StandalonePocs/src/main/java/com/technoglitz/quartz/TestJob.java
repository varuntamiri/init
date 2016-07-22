package com.technoglitz.quartz;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * The Class TestJob. Reference http://www.dzone.com/links/r/quartz_2_scheduler_example.html
 */
public class TestJob implements Job {

	/** The log. */
	private Logger log = Logger.getLogger(TestJob.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	public void execute(JobExecutionContext jExeCtx) throws JobExecutionException {
		log.debug("TestJob run successfully...");
		System.out.println("TestJob run successfully...");
	}

}

