package com.angshi.mimicwebpolicy.service;

import com.angshi.mimicwebpolicy.service.command;
import com.angshi.mimicwebpolicy.util.SystemUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Commandimpl implements command {
    @Override
    public String reboot(Integer m) {
        try{
            Thread.sleep(m*1000);
        }catch (Exception e){
            log.warn(e.getLocalizedMessage());
        }
        return SystemUtil.excuteShell("reboot");
    }

    @Override
    public String shutDown(Integer m) {
        SystemUtil.excuteShell("killall java");
        return SystemUtil.excuteShell("shutdown -h now");
    }

    @Override
    public String reset() {
        return null;
    }

    @Override
    public String unInstall() {
        return null;
    }
}
