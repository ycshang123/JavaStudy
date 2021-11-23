package top.ycshang.basedao.lambda;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-24 00:36
 **/
public class CalFunTest {
    public static void main(String[] args) {
        //calTest01();
        //calTest02(2, 3, (t1, t2) -> t1 * t2);
        //convertTest01();
        //convertTest02();
        //convertTest03(2, String::valueOf);
        //convertTest04("FunctionInterfaceTest", String::valueOf);
        //logTest01(() -> System.out.println("hello，函数式接口"));
        //logTest011();
        //logTest012();
        //logTest013();
        logTest021(new Pupil(111,"小朗",10,222,"张老师"));
        logTest022(new Pupil(111,"小华",12,333,"李老师"));
        logTest031(new Pupil(111,"小华",12,333,"李老师"));
    }

    /**
     * 通过自定义函数式接口实现数值运算
     */
    private static void calTest01() {
        CalFunctionalInterface<Integer, Integer> add = Integer::sum;
        Integer cal = add.cal(1, 2);
        System.out.println(cal.toString());
    }

    /**
     * 将函数式接口当参数传入 test02(2, 3, (t1, t2) -> t1 * t2);
     *
     * @param t1    入参1
     * @param t2    入参2
     * @param fun 函数式接口
     */
    private static void calTest02(Integer t1, Integer t2, CalFunctionalInterface<Integer, Integer> fun) {
        Integer cal = fun.cal(t1, t2);
        System.out.println(cal.toString());
    }

    /**
     * 通过自定义函数式接口实现数据类型转换
     */
    private static void convertTest01() {
        ConvertFunctionInterface<Integer, String> convert = String::valueOf;
        String ret = convert.convert(2);
        System.out.println(ret + 4);
    }

    /**
     * 使用"::"运算符更精简
     */
    private static void convertTest02() {
        ConvertFunctionInterface<Integer, String> convert = String::valueOf;
        String ret = convert.convert(2);
        System.out.println(ret + 4);
    }

    /**
     * 使用"::"运算符更精简
     */
    private static void convertTest03(Integer t, ConvertFunctionInterface<Integer, String> fun) {
        String ret = fun.convert(t) + 4;
        System.out.println(ret);
    }

    /**
     * @param t   t
     * @param fun fun
     */
    private static void convertTest04(String t, ConvertFunctionInterface<String, String> fun) {
        String ret = fun.convert(t);
        System.out.println(ret);
    }

    private static void logTest01(LogFunction logFunction) {
        logFunction.log();
    }

    private static void logTest011() {
        //调用log方法，方法的参数是一个接口，所以可以传递接口的实现类对象
        logTest01(new LogFunction() {
            @Override
            public void log() {
                System.out.println("函数式接口练习011");
            }
        });
    }

    /**
     * 调用log方法，方法的参数是一个函数式接口，所以，可以使用lambda表达式
     */
    private static void logTest012() {
        //调用log方法，方法的参数是一个接口，所以可以传递接口的实现类对象
        logTest01(() -> {
            System.out.println("函数式接口练习012");
        });
    }

    /**
     * 简化lambda表达式
     */
    private static void logTest013() {
        logTest01(() -> System.out.println("函数式接口练习013"));
    }

    private static void logTest02(Pupil pupil, LogFunction2<Pupil> logFunction2) {
        logFunction2.log(pupil);
    }

    private static void logTest021(Pupil pupil) {
        logTest02(pupil, new LogFunction2<Pupil>() {
            @Override
            public void log(Pupil t) {
                String ret = t.getId() + "->" + t.getName() + "->" + t.getAge();
                System.out.println(ret);
            }
        });
    }

    private static void logTest022(Pupil pupil) {
        logTest02(pupil, (Pupil t) -> {
            String ret = t.getId() + "->" + t.getName() + "->" + t.getAge();
            System.out.println(ret);
        });
    }


    private static void logTest03(Pupil pupil, LogFunction3<Pupil, PupilTeacher> logFunction3) {
        logFunction3.build(pupil);
    }

    /**
     * @param pupil pupil
     */
    private static void logTest031(Pupil pupil) {
        logTest03(pupil, s -> {
            PupilTeacher t = new PupilTeacher();
            t.setTeacherId(s.getTeacherId());
            t.setTeacherName(s.getTeacherName());
            System.out.println(t);
            return t;
        });
    }
}