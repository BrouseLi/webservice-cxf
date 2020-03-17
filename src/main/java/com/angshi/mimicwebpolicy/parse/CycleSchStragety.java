package com.angshi.mimicwebpolicy.parse;

import lombok.Data;

import java.util.List;

@Data
public class CycleSchStragety {
    public String time;
    public List<String> targetIpList;
    public int updateFlag; //2位标识， 01 代表时间更新，10代表 ip列表更新
}
