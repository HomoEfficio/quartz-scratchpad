package io.homo.efficio.scratchpad.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-08-12
 */
public abstract class BaseJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        doExecute(context);
    }

    protected abstract void doExecute(JobExecutionContext context);
}
