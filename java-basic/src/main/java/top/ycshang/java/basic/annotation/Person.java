package top.ycshang.java.basic.annotation;

import java.lang.annotation.Repeatable;

/**
 * @description:
 * @author: ycshang
 * @create: 2021-11-10 20:11
 **/
@Repeatable(Persons.class)
public @interface Person{
    String role() default "";
}
