package com.angshi.mimicwebpolicy.job;

import com.angshi.mimicwebpolicy.util.ElasticUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

//@Configuration
//@EnableScheduling
public class SaticScheduleTask {
    //@Autowired
    private ElasticUtil elasticUtil;
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() throws IOException {
        //elasticUtil.searchAccess("logstash-test1access-2018.08.18", "_doc", "2018-08-18T05:26");
        //System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}
