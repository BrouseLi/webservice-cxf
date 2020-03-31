package com.angshi.mimicwebpolicy.service;

import com.angshi.mimicwebpolicy.service.PolicyVoter;
import com.angshi.mimicwebpolicy.util.SystemUtil;
import org.junit.jupiter.api.Test;

public class PolicyVoterimpl implements PolicyVoter {

    @Override
    public boolean relaceNginxConf(String name) {
        return false;
    }
    @Test
    public void testReplaceNginxConf(){
        /**
         * 关闭nginx
         *
         */

        /**
         * 指定策略配置文件
         */
        String result = SystemUtil.excuteShell("C:\\phpStudy\\nginx\\nginx.exe -c C:\\phpStudy\\nginx\\conf");
    }
}
