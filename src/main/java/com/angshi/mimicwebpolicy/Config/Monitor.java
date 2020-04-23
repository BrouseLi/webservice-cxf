package com.angshi.mimicwebpolicy.Config;

import com.angshi.mimicwebpolicy.client.CxfClient;
import com.angshi.mimicwebpolicy.service.ReportLog;
import com.angshi.mimicwebpolicy.service.TestWarn;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.io.IOException;

//@Configuration
//@EnableScheduling
@Slf4j
public class Monitor implements SchedulingConfigurer {
    @Autowired
    private TestWarn testWarn;
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    try {
                        testWarn.testReportLog();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1从配置文件获取执行周期
                    String cron = "10 * * * * ?";
                    log.info("获取到定时"+cron+"===================");
                    //2.2 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
