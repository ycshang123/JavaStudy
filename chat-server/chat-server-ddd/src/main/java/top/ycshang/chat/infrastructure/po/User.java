package top.ycshang.chat.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 用户
 *
 * @author ycshang
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private Long id;
    private String userId;
    private String userNickName;
    private String userHead;
    private String userPassword;
    private Date createTime;
    private Date updateTime;

}
