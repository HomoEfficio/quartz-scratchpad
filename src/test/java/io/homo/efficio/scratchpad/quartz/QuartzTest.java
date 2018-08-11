package io.homo.efficio.scratchpad.quartz;

import org.junit.Test;
import org.quartz.JobDetail;

import static org.quartz.JobBuilder.newJob;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-08-12
 */
public class QuartzTest {

    @Test
    public void helloJob() {
        JobDetail jobDetail = newJob(HelloJob.class)
                .build();
    }
}
