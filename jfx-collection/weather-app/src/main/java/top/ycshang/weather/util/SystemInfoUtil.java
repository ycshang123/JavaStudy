package top.ycshang.weather.util;

import com.alibaba.fastjson.JSONObject;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.text.DecimalFormat;
import java.util.Properties;

/**
 * @program: jfx-collection
 * @description:
 * @author: ycshang
 * @create: 2021-10-17 21:07
 **/
public class SystemInfoUtil {
    private static final int OSHI_WAIT_SECOND = 1000;
    private static final SystemInfo SYSTEM_INFO = new SystemInfo();
    private static final HardwareAbstractionLayer HARDWARE_ABSTRACTION_LAYER = SYSTEM_INFO.getHardware();
    private static final OperatingSystem OPERATING_SYSTEM = SYSTEM_INFO.getOperatingSystem();
    private static final double FORMAT = 1024.0;

    public static JSONObject getCpuInfo() {
        JSONObject cpuInfo = new JSONObject();
        CentralProcessor processor = HARDWARE_ABSTRACTION_LAYER.getProcessor();
        //CPU信息
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(OSHI_WAIT_SECOND);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softIrq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long ioWait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + ioWait + irq + softIrq + steal;
        //cpu核数
        cpuInfo.put("cpuNum", processor.getLogicalProcessorCount());
        cpuInfo.put("cSys", new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));

        return cpuInfo;
    }

    public static JSONObject getJvmInfo() {
        JSONObject cpuInfo = new JSONObject();
        Properties properties = System.getProperties();
        Runtime runtime = Runtime.getRuntime();
        long jvmTotalMemoryByte = runtime.totalMemory();
        long freeMemoryByte = runtime.freeMemory();
        //jvm总内存
        cpuInfo.put("total", formatByte(runtime.totalMemory()));
        //空闲空间
        cpuInfo.put("free", formatByte(runtime.freeMemory()));
        //jvm最大可申请
        cpuInfo.put("max", formatByte(runtime.maxMemory()));
        //vm已使用内存
        cpuInfo.put("user", formatByte(jvmTotalMemoryByte - freeMemoryByte));
        //jvm内存使用率
        cpuInfo.put("usageRate", new DecimalFormat("#.##%").format((jvmTotalMemoryByte - freeMemoryByte) * 1.0 / jvmTotalMemoryByte));
        //jdk版本
        cpuInfo.put("jdkVersion", properties.getProperty("java.version"));
        //jdk路径
        cpuInfo.put("jdkHome", properties.getProperty("java.home"));
        return cpuInfo;
    }

    /**
     * 单位转换
     */
    private static String formatByte(long byteNumber) {
        //换算单位
        double kbNumber = byteNumber / FORMAT;
        if (kbNumber < FORMAT) {
            return new DecimalFormat("#.##KB").format(kbNumber);
        }
        double mbNumber = kbNumber / FORMAT;
        if (mbNumber < FORMAT) {
            return new DecimalFormat("#.##MB").format(mbNumber);
        }
        double gbNumber = mbNumber / FORMAT;
        if (gbNumber < FORMAT) {
            return new DecimalFormat("#.##GB").format(gbNumber);
        }
        double tbNumber = gbNumber / FORMAT;
        return new DecimalFormat("#.##TB").format(tbNumber);
    }

    public static JSONObject getMemInfo() {
        JSONObject cpuInfo = new JSONObject();
        GlobalMemory memory = SYSTEM_INFO.getHardware().getMemory();
        //总内存
        long totalByte = memory.getTotal();
        //剩余
        long acaliableByte = memory.getAvailable();
        //总内存
        cpuInfo.put("total", formatByte(totalByte));
        //使⽤
        cpuInfo.put("used", formatByte(totalByte - acaliableByte));
        //剩余内存
        cpuInfo.put("free", formatByte(acaliableByte));
        //使⽤率
        cpuInfo.put("usageRate", new
                DecimalFormat("#.##%").format((totalByte - acaliableByte) * 1.0 /
                totalByte));
        return cpuInfo;
    }

    public static JSONObject getInfo() {
        JSONObject info = new JSONObject();
        info.put("cpuInfo", getCpuInfo());
        info.put("jvmInfo", getJvmInfo());
        info.put("memInfo", getMemInfo());
        return info;
    }
}