package top.ycshang.basedao.enmu;

import java.util.Arrays;

class WeekdayTest {
    public static void main(String[] args) {
        //testSwitch(Weekday.MONDAY);
        //1、ordinal(),枚举顺序值
        System.out.println("枚举顺序值," + Weekday.MONDAY.ordinal());

        Week week = Enum.valueOf(Week.class, Week.MONDAY.name());
        Week week1 = Week.valueOf(Week.class, Week.MONDAY.name());
        //MONDAY
        System.out.println("Enum.valueOf," + week);
        //MONDAY
        System.out.println("Week.valueOf," + week1);

        //3、values()
        //返回一个Weekday数组
        System.out.println("Week.values()," + Arrays.toString(Weekday.values()));

        //4、通过compareTo方法比较,实际上其内部是通过ordinal()值比较的
        //false
        System.out.println("Weekday.MONDAY.compareTo(Weekday.TUESDAY)," + Weekday.MONDAY.compareTo(Weekday.TUESDAY));

        //5、获取该枚举对象的Class对象引用,当然也可以通过getClass方法
        Class<?> declaringClass = Weekday.MONDAY.getDeclaringClass();

        System.out.println("获取该枚举对象的Class对象引用," + declaringClass);

        //6、通过getEnumConstants()获取该枚举类型的所有元素，如果Class对象不是枚举类型，则返回null。
        Object[] enumConstants = declaringClass.getEnumConstants();
        //枚举类个数,Weekday.values().length)
        for (int i = 0; i < Weekday.values().length; i++) {
            //SUNDAY、MONDAY、TUESDAY、WEDNESDAY、THURSDAY、FRIDAY、SATURDAY
            System.out.println("getEnumConstants," + enumConstants[i]);
        }

        //7、判断是否是枚举类型
        //true
        System.out.println("declaringClass.isEnum()," + declaringClass.isEnum());

        //8、获取枚举变量的属性
        System.out.println("编号," + Week.MONDAY.getId() + ",含义," + Week.MONDAY.getMeaning());

    }

    static void testSwitch(Weekday weekday) {
        switch (weekday) {
            case MONDAY:
            case SUNDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
            case SATURDAY:
                System.out.println(weekday.getValue());
                break;
            default:
                System.out.println("输入有误");
                break;
        }
    }

}