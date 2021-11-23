package top.ycshang.basedao.lambda;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:25
 **/
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private String name;
    private Integer age;
}