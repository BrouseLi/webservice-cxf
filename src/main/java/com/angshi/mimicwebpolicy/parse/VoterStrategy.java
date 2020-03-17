package com.angshi.mimicwebpolicy.parse;

import java.util.List;

public class VoterStrategy {
    public String schclean_strategy;
    public String  voter_strategy;
    public List<String> targetIpList;
    public int updateFlag; // 3位标识，001 代表清洗策略更新，010 代表 表决策略更新 100 代表 ip列表更新

}
