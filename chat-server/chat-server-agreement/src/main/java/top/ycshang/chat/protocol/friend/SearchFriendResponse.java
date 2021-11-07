package top.ycshang.chat.protocol.friend;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import top.ycshang.chat.protocol.Command;
import top.ycshang.chat.protocol.Packet;
import top.ycshang.chat.protocol.friend.dto.UserDto;

import java.util.List;

/**
 * 搜索好友应答
 *
 * @author ycshang
 */
@Getter
@Setter
@ToString
public class SearchFriendResponse extends Packet {

    private List<UserDto> list;

    @Override
    public Byte getCommand() {
        return Command.SearchFriendResponse;
    }
}
