package top.ycshang.chat.domain.inet.model;

/**
 * @author ycshang
 */
public class InetServerInfo {

    private String ip;
    private int port;
    /**
     * 状态；true开启、false关闭
     */
    private boolean status;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
