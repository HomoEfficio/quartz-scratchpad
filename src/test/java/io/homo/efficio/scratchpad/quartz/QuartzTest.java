package io.homo.efficio.scratchpad.quartz;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-08-12
 */
public class QuartzTest {

    @Test
    public void helloJob() throws SchedulerException, InterruptedException {

        // Job 구현 내용이 담긴 HelloJob으로 JobDetail 생성
        JobDetail jobDetail = newJob(HelloJob.class)
                .build();

        // 실행 시점을 결정하는 Trigger 생성
        Trigger trigger = newTrigger()
                .build();

        // 스케줄러 실행 및 JobDetail과 Trigger 정보로 스케줄링
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        defaultScheduler.start();
        defaultScheduler.scheduleJob(jobDetail, trigger);
        Thread.sleep(3 * 1000);  // Job이 실행될 수 있는 시간 여유를 준다

        // 스케줄러 종료
        defaultScheduler.shutdown(true);
    }
}
