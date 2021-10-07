package top.ycshang.java.basic.reflect;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-10-07 19:38
 **/
@Slf4j
public class TargetObject {
    private final String value;

    public TargetObject() {
        this.value = "default";
    }

    public void publicMethod(String s) {
        log.info("I love" + s);
    }

    public void privateMethod() {
        log.info("value is" + value);
    }
}