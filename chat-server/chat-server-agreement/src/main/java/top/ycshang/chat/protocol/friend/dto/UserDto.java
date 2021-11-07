package top.ycshang.chat.protocol.friend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDto
 *
 * @author ycshang
 */
@Data
public class UserDto {

    private String userId;
    private String userNickName;
    private String userHead;
    private Integer status;

    public UserDto() {
    }

    public UserDto(String userId, String userNickName, String userHead) {
        this.userId = userId;
        this.userNickName = userNickName;
        this.userHead = userHead;
    }

}
