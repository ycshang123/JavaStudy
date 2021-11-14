package top.ycshang.basedao.dao.impl;

import top.ycshang.basedao.dao.BaseDao;
import top.ycshang.basedao.dao.BookDao;
import top.ycshang.basedao.entity.Book;

/**
 * @program: basedao-sample
 * @description: 继承BaseDaoImpl,实现BookDao接口，并指定泛型
 * @author: ycshang
 * @create: 2021-11-14 22:20
 **/
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao<Book> {
}