package com.angshi.mimicwebpolicy.service;

public interface command {
    /**
     * 设备延时重启
     * @param m 延时时间 单位 秒
     * @return 执行结果
     */
    public String reboot(Integer m);

    /**
     * 设备延时关机
     * @param m 延时时间 单位 秒
     * @return 执行结果
     */
    public String shutDown(Integer m);

    /**
     * 设备恢复出厂设置
     * 操作：
     *1
     * @return 执行结果
     */
    public String  reset();

    /**
     * 卸载安管
     * 操作：
     * 1 停止向安管上报数据
     * 2 清除安管下发配置
     * @return
     */
    public String unInstall();
}
