package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-21 21:58
 **/
public class LambdaInfer {
    public static void main(String[] args) {
        //匿名内部类
        IStudent student = new IStudent() {
            @Override
            public void study(String technology, int time) {
                System.out.println("匿名内部类," + technology + time);
            }
        };
        student.study("java", 8);

        //Lambda表达式改造（将类名和方法名去掉）
        IStudent student1 = (String technology, int time) -> {
            System.out.println("Lambda表达式改造（将类名和方法名去掉）" + technology + time);
        };
        student1.study("java", 8);

        //一级进化（去掉数据类型）
        IStudent student2 = ((technology, time) -> {
            System.out.println("一级进化（去掉数据类型）" + technology + time);
        });
        student2.study("java", 8);

        //二级进化（简化括号）,一般进行一次进化就可以了，二级进化没必要
        IStudent student3 = ((technology, time) -> System.out.println("二级进化（简化括号）" + technology + time));
        student3.study("java", 8);
    }
}