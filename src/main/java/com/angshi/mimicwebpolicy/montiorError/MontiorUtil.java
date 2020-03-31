package com.angshi.mimicwebpolicy.montiorError;


import com.angshi.mimicwebpolicy.util.OkHttpUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MontiorUtil {
    private  Date date= Date.from(Instant.now());
    @Test
    public void print()throws Exception{
        String ip = "172.16.18.154";
        String path="http://" + ip + ":9090/api/v1/query?query=";
        String [] strings={"ipmi_bmc_info", "ipmi_chassis_power_state", "ipmi_fan_speed_rpm", "ipmi_fan_speed_state",
                "ipmi_scrape_duration_seconds", "ipmi_sensor_state", "ipmi_sensor_value", "ipmi_temperature_celsius",
                "ipmi_temperature_state", "ipmi_up", "ipmi_voltage_state", "ipmi_voltage_volts"};
        List<String>list = Arrays.asList(strings);
        /*for (String s:list){
            System.out.println(path+s+"&time="+time);
            //;
        }*/
        OkHttpUtil okHttpUtil = OkHttpUtil.getInstance();
        String time=String.valueOf(date.getTime())+".282911";
        System.out.println(okHttpUtil.getData("http://172.16.18.154:9090/api/v1/query?query=ipmi_fan_speed_rpm&time="+time).body().string());
    }
}
