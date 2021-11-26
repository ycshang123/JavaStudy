package top.ycshang.basedao.thread;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-27 00:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Message {
    private int id;
    private Object value;
}