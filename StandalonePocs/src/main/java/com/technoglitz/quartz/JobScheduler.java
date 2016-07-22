package com.technoglitz.quartz;


import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.technoglitz.quartz.TestJob;


/**
* @author onlinetechvision.com
* @since 17 Sept 2011
* @version 1.0.0
* Reference http://www.dzone.com/links/r/quartz_2_scheduler_example.html
*/
public class JobScheduler {

   public static void main(String[] args) {

      try {

         // specify the job' s details..
         JobDetail job = JobBuilder.newJob(TestJob.class)
                                   .withIdentity("testJob")
                                   .build();

         // specify the running period of the job
         Trigger trigger = TriggerBuilder.newTrigger()
                                         .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                                            .withIntervalInSeconds(30)
                                                                            .repeatForever()).build();

         //schedule the job
         SchedulerFactory schFactory = new StdSchedulerFactory();
         Scheduler sch = schFactory.getScheduler();
         sch.start();
         sch.scheduleJob(job, trigger);

      } catch (SchedulerException e) {
         e.printStackTrace();
      }
   }

}


