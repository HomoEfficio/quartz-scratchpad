package io.homo.efficio.scratchpad.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-08-12
 */
@Slf4j
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("### Hello Job is being executed!");
    }
}
