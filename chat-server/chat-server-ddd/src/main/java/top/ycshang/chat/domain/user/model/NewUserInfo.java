package top.ycshang.chat.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新用户
 *
 * @author ycshang
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserInfo {

    private String userId;
    private String userNickName;
    private String userHead;
    /**
     * 状态；0添加、1[保留]、2已添加
     */
    private Integer status;

}
