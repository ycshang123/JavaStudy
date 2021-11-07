package top.ycshang.chat.protocol.login.dto;

import lombok.Data;

/**
 * 用户好友Dto
 *
 * @author ycshang
 */
@Data
public class UserFriendDto {

    private String friendId;
    private String friendName;
    private String friendHead;

}
