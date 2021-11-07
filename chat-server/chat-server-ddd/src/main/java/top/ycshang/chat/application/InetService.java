package top.ycshang.chat.application;




import top.ycshang.chat.domain.inet.model.ChannelUserInfo;
import top.ycshang.chat.domain.inet.model.ChannelUserReq;
import top.ycshang.chat.domain.inet.model.InetServerInfo;

import java.util.List;

/**
 * 网络信息查询
 *
 * @author ycshang
 */
public interface InetService {

    /**
     * 查询Netty服务器信息
     *
     * @return InetServerInfo
     */
    InetServerInfo queryNettyServerInfo();

    /**
     * @param req 请求
     * @return Channel用户数
     */
    Long queryChannelUserCount(ChannelUserReq req);

    /**
     * @param req 请求
     * @return List<ChannelUserInfo>
     */
    List<ChannelUserInfo> queryChannelUserList(ChannelUserReq req);

}
