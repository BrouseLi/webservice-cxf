package com.angshi.mimicwebpolicy.job;
import com.angshi.mimicwebpolicy.util.ElasticUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * Spring动态周期定时任务
 * 在不停应用的情况下更改任务执行周期
 * @Author 邢福康
 * @Create 2020-04-15 16:31:29
 */
//@Lazy(false)
//@Component
//@EnableScheduling
//@Getter
//@Setter
public class test implements SchedulingConfigurer {
    private static String cron;
    private static int time;
    @Autowired
    private ElasticUtil elasticUtil;
    public test() {
        cron = "0/5 * * * * ?";
        time = 60;
        // 开启新线程模拟外部更改了任务执行周期
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                cron = "0/10 * * * * ?";
                time = 5;
                System.err.println("cron change to: " + cron);
            }
        }).start();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 任务逻辑
                try {
                    elasticUtil.searchtime1("logstash-test1access-2018.08.18", "_doc", "2018-08-18T19:23:02",time);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 任务触发，可修改任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExec = trigger.nextExecutionTime(triggerContext);
                return nextExec;
            }
        });
    }
}