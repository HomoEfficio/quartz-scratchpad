package io.homo.efficio.scratchpad.quartz;

import org.junit.Test;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
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
    public void helloJob() {
        JobDetail jobDetail = newJob(HelloJob.class)
                .build();

        Trigger trigger = newTrigger()
                .build();
    }
}
