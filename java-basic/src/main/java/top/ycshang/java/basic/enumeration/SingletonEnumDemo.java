package top.ycshang.java.basic.enumeration;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description: 利用枚举实现单例
 * 因为枚举类的构造方法只能被声明为private权限或者不声明权限
 * @author: ycshang
 * @create: 2021-09-29 21:19
 **/
@Slf4j
public class SingletonEnumDemo {

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.setName("soft");
        log.info(SingletonEnum.INSTANCE.getName());
    }

    /**
     * 内部私有枚举
     */
    private enum SingletonEnum {
        /**
         * 枚举实例(单例)
         */
        INSTANCE;
        private String name;

        private String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}