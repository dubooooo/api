package com.dubooooo.api.common;

import lombok.Data;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.Map;

@Data
public class SystemInfo {

    private String totalMemory;//内存总量
    private String freeMemory;//空闲内存量
    private String maxMemory;//最大内存量
    private String heapMemoryInit;//初始化 Heap
    private String heapMemoryMax;//最大Heap
    private String heapMemoryUsed;//已经使用Heap
    private String heapMemoryUsage;//Heap Memory Usage
    private String nonHeapMemoryUsage;//NonHeapMemoryUsage

    private Map<Thread, StackTraceElement[]> allStackTraces;
    private long threadCount;//
    private long peakThreadCount;//
    private long totalStartedThreadCount;//
    private long daemonThreadCount;//
    private long[] allThreadIds;//
    private long currentThreadCpuTime;//
    private long currentThreadUserTime;//

    public static SystemInfo buildThreadMXBeanInfo(SystemInfo systemInfo) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        systemInfo.setThreadCount(threadMXBean.getThreadCount());
        systemInfo.setPeakThreadCount(threadMXBean.getPeakThreadCount());
        systemInfo.setTotalStartedThreadCount(threadMXBean.getTotalStartedThreadCount());
        systemInfo.setDaemonThreadCount(threadMXBean.getDaemonThreadCount());
        systemInfo.setAllThreadIds(threadMXBean.getAllThreadIds());
        systemInfo.setCurrentThreadCpuTime(threadMXBean.getCurrentThreadCpuTime());
        systemInfo.setCurrentThreadUserTime(threadMXBean.getCurrentThreadUserTime());
        systemInfo.setAllStackTraces(Thread.getAllStackTraces());
        return systemInfo;
    }

    public static SystemInfo build() {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setTotalMemory(String.valueOf(Runtime.getRuntime().totalMemory() / 1024 / 1024));
        MemoryMXBean memoryMBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMBean.getHeapMemoryUsage();
        systemInfo.setHeapMemoryInit(String.valueOf(usage.getInit() / 1024 / 1024));
        systemInfo.setHeapMemoryMax(String.valueOf(usage.getMax() / 1024 / 1024));
        systemInfo.setHeapMemoryUsed(String.valueOf(usage.getUsed() / 1024 / 1024));
        systemInfo.setHeapMemoryUsage(memoryMBean.getHeapMemoryUsage().toString());
        systemInfo.setNonHeapMemoryUsage(memoryMBean.getNonHeapMemoryUsage().toString());
        return systemInfo;
    }

}
