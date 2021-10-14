package top.ycshang.java.basic.method;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-10-14
 **/
@AllArgsConstructor
@NoArgsConstructor
class ReturnObject {
    private Integer max;
    private Integer min;
    private Integer sum;

    @Override
    public String toString() {
        return "ReturnObject{" +
                "max=" + max +
                ", min=" + min +
                ", sum=" + sum +
                '}';
    }
}