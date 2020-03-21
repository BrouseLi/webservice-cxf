package com.angshi.mimicwebpolicy.service.impl;

import com.angshi.mimicwebpolicy.service.command;
import com.angshi.mimicwebpolicy.util.SystemUtil;

public class Commandimpl implements command {
    @Override
    public String reboot(Integer m) {
        return SystemUtil.excuteShell("");
    }

    @Override
    public String shutDown(Integer m) {
        SystemUtil.excuteShell("killall java");
        return SystemUtil.excuteShell("shutdown -f "+m);
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
