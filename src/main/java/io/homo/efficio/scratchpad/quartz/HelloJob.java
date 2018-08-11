package io.homo.efficio.scratchpad.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-08-12
 */
@Slf4j
public class HelloJob extends BaseJob {

    @Override
    protected void doExecute(JobExecutionContext context) {
        log.info("### Hello Job is being executed!");
    }
}
