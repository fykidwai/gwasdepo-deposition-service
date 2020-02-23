package uk.ac.ebi.spot.gwas.deposition.scheduler.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import uk.ac.ebi.spot.gwas.deposition.scheduler.tasks.SubmissionsCleanUpTask;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SubmissionsCleanUpJob extends QuartzJobBean {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) {
        applicationContext.getBean(SubmissionsCleanUpTask.class).cleanUp();
    }
}
