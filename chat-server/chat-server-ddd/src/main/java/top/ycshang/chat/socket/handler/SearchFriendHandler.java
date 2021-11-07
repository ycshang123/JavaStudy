package top.ycshang.chat.socket.handler;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import top.ycshang.chat.application.UserService;
import top.ycshang.chat.domain.user.model.NewUserInfo;
import top.ycshang.chat.protocol.friend.SearchFriendRequest;
import top.ycshang.chat.protocol.friend.SearchFriendResponse;
import top.ycshang.chat.protocol.friend.dto.UserDto;
import top.ycshang.chat.socket.MyBizHandler;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ycshang
 */
public class SearchFriendHandler extends MyBizHandler<SearchFriendRequest> {

    public SearchFriendHandler(UserService userService) {
        super(userService);
    }

    @Override
    public void channelRead(Channel channel, SearchFriendRequest msg) {
        logger.info("搜索好友请求处理：{}", JSON.toJSONString(msg));
        List<UserDto> userDtoList = new ArrayList<>();
        List<NewUserInfo> userInfoList = userService.queryFuzzyUserInfoList(msg.getUserId(), msg.getSearchKey());
        for (NewUserInfo userInfo : userInfoList) {
            UserDto userDto = new UserDto();
            userDto.setUserId(userInfo.getUserId());
            userDto.setUserNickName(userInfo.getUserNickName());
            userDto.setUserHead(userInfo.getUserHead());
            userDto.setStatus(userInfo.getStatus());
            userDtoList.add(userDto);
        }
        SearchFriendResponse response = new SearchFriendResponse();
        response.setList(userDtoList);
        channel.writeAndFlush(response);
    }

}
