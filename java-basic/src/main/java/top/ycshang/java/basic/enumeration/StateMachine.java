package top.ycshang.java.basic.enumeration;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: java-basic
 * @description:
 * @author: ycshang
 * @create: 2021-09-29 21:30
 **/
@Slf4j
public class StateMachine {
    public static String getTrafficInstruct(Signal signal) {
        String instruct = "信号灯故障";
        switch (signal) {
            case RED:
                instruct = "红灯停";
                break;
            case GREEN:
                instruct = "绿灯行";
                break;
            case YELLOW:
                instruct = "黄灯请注意";
            default:
                break;
        }
        return instruct;

    }

    public static void main(String[] args) {
        log.info(getTrafficInstruct(Signal.GREEN));
        log.info(getTrafficInstruct(Signal.YELLOW));
        log.info(getTrafficInstruct(Signal.RED));

    }
}