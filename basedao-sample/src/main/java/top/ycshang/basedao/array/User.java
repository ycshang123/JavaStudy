package top.ycshang.basedao.array;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-19 19:55
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String name;
    private Integer age;
}