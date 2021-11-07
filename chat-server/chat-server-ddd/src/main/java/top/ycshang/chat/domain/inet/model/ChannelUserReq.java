package top.ycshang.chat.domain.inet.model;

import lombok.*;
import top.ycshang.chat.infrastructure.common.PageReq;


/**
 * @author ycshang
 */
@Getter
@Setter
@ToString
public class ChannelUserReq extends PageReq {

    private String userId;
    private String userNickName;

}
