package top.ycshang.basedao.dao;

import java.util.List;

public interface BaseDao<T> {
    /**
     * 新增
     *
     * @param t
     */
    void add(T t);

    /**
     * 删除
     *
     * @param t
     */
    void delete(T t);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 根据指定的属性查找
     *
     * @param fielsName
     * @param value
     * @return
     */
    List<T> findByField(String fieldName, Object value);

    /**
     * 更新
     * @param t
     * @param id
     */
    void update(T t,Long id);

    /**
     * 查询所有
     * @return
     */
    List<T> findAll();
}
