package top.ycshang.basedao.dao.impl;

import top.ycshang.basedao.context.DataContext;
import top.ycshang.basedao.dao.BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: basedao-sample
 * @description:
 * @author: ycshang
 * @create: 2021-11-14 22:20
 **/
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    //具体哪一个dao的实现类
    private final Class<T> clazz;
    private final List<T> list;

    public BaseDaoImpl() {
        //this.getClass() 代表当前运行对象的Class对象
        Class<?> cClass = this.getClass();
        //cClass.getGenericSuperclass() 得到当前对象的父类(参数化类型)
        Type type = cClass.getGenericSuperclass();
        //向下转型为参数化型对象
        ParameterizedType pt = (ParameterizedType) type;
        //得到参数化类型(泛型类型列表)
        Type[] types = pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];
        list = (List<T>) DataContext.getData();

    }

    private static <T> List<T> findByField(List<T> list, String field, Object value, Class<T> clazz) {
        List<T> res = new ArrayList<>();
        try {
            //    通过反射获取指定属性
            Field classField = clazz.getDeclaredField(field);
            //设置属性为可访问
            classField.setAccessible(true);
            for (T t : list) {
                //    遍历list,获取到对应的属性的值
                Object o = classField.get(t);
                if (value.toString().equals(o.toString())) {
                    //和预期相等，加入到返回值中
                    res.add(t);
                }
            }
        } catch (NoSuchFieldException e) {
            //如果这个字段不存在 直接返回空
            return null;
        } catch (IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return res;
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void delete(T t) {
        list.remove(t);

    }

    @Override
    public T get(Long id) {
        List<T> res = findByField(list, "id", id, clazz);
        return Objects.requireNonNull(res).get(0);
    }

    @Override
    public List<T> findByField(String fieldName, Object value) {
        return findByField(list, fieldName, value, clazz);
    }

    @Override
    public void update(T t, Long id) {
        Field field = null;
        try {
            field = clazz.getDeclaredField("id");

        } catch (NoSuchFieldException e) {
            System.err.println(e.getMessage());
        }
        Objects.requireNonNull(field).setAccessible(true);
        //    查找数据集中和id值和入参相等的对象
        for (int i = 0; i < list.size(); i++) {
            T next = list.get(i);
            Object o = null;
            try {
                o = field.get(next);
                if (id.equals(o)) {
                    list.add(i, t);
                    break;
                }
            } catch (IllegalAccessException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    @Override
    public List<T> findAll() {
        return list;
    }
}