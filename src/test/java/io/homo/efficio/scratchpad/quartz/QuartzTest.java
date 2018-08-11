package io.homo.efficio.scratchpad.quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.LinkedList;
import java.util.List;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-08-12
 */
public class QuartzTest {

    @Test
    public void helloJob() throws SchedulerException, InterruptedException {

        // Job 1 구성
        JobDataMap jobDataMap1 = new JobDataMap();
        jobDataMap1.put("JobName", "Job Chain 1");
        JobDetail jobDetail1 = newJob(HelloJob.class)
                .usingJobData(jobDataMap1)
                .build();

        // Job 2 구성
        JobDataMap jobDataMap2 = new JobDataMap();
        jobDataMap2.put("JobName", "Job Chain 2");
        JobDetail jobDetail2 = newJob(HelloJob.class)
                .usingJobData(jobDataMap2)
                .build();

        // Job 3 구성
        JobDataMap jobDataMap3 = new JobDataMap();
        jobDataMap3.put("JobName", "Job Chain 3");
        JobDetail jobDetail3 = newJob(HelloJob.class)
                .usingJobData(jobDataMap3)
                .build();

        // 실행할 모든 Job의 JobDetail를 jobDetail1의 JobDataMap에 담는다.
        List<JobDetail> jobDetailQueue = new LinkedList<>();
        jobDetailQueue.add(jobDetail1);
        jobDetailQueue.add(jobDetail2);
        jobDetailQueue.add(jobDetail3);
        jobDetail1.getJobDataMap().put("JobDetailQueue", jobDetailQueue);


        // Trigger 생성 - 첫 번째 Job에 대한 트리거만 있으면 된다.
        Trigger trigger = newTrigger()
                .build();


        // 스케줄러 실행 및 JobDetail과 Trigger 정보로 스케줄링
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.start();
        defaultScheduler.scheduleJob(jobDetail1, trigger);
        Thread.sleep(3 * 1000);  // Job이 실행될 수 있는 시간 여유를 준다

        // 스케줄러 종료
        defaultScheduler.shutdown(true);
    }
}
