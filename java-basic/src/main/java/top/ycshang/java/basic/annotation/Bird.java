package top.ycshang.java.basic.annotation;

/**
 * @description:
 * @author: ycshang
 * @create: 2021-11-10 21:05
 **/
@Desc(c = Desc.Color.White)
abstract class Bird {
    public abstract Desc.Color getColor();
}
