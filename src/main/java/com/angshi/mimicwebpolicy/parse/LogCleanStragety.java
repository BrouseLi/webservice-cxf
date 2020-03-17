package com.angshi.mimicwebpolicy.parse;

import java.util.List;

public class LogCleanStragety {
    public String time;
    public String  diskSpace;
    public List<String> targetIpList;
    public int updateFlag; // 3位标识，001 代表 时间更新，010 代表空间更新， 100代表ip列表更新。
}
