package top.ycshang.basedao.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import top.ycshang.basedao.context.DataContext;
import top.ycshang.basedao.dao.impl.BookDaoImpl;
import top.ycshang.basedao.entity.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unchecked")
@Slf4j
class BaseDaoTest {
    private void init() {
        Book book1 = new Book(1L, "1001", "Java从入门到精通", 88.8, LocalDate.of(2021, 11, 13));
        Book book2 = new Book(2L, "1002", "Java编程思想", 98.8, LocalDate.of(2021, 11, 11));
        Book book3 = new Book(3L, "1003", "Java并发编程", 88.8, LocalDate.of(2021, 11, 9));
        List<Book> list = new ArrayList<>(Arrays.asList(book1, book2, book3));
        DataContext.setData(list);
        log.info("****************初始化*****************");
        printData();
    }

    private void printData() {
        List<Book> books = (List<Book>) DataContext.getData();
        books.forEach(item -> log.info(String.valueOf(item)));
    }

    @Test
    void add() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book book = new Book(4L, "1004", "新增书籍", 88.8, LocalDate.of(2021, 6, 6));
        bookDao.add(book);
        assertEquals(4, ((List<Book>) DataContext.getData()).size());
        log.info("****************新增*****************");
        printData();

    }

    @Test
    void delete() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book delBook = ((List<Book>) DataContext.getData()).get(2);
        bookDao.delete(delBook);
        assertEquals(2, ((List<Book>) DataContext.getData()).size());
        log.info("****************删除*****************");
        printData();
    }

    @Test
    void get() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book book = bookDao.get(3L);
        assertEquals(book, ((List<Book>) DataContext.getData()).get(2));
        log.info("****************根据id查询*****************");
        log.info(String.valueOf(book));
    }

    @Test
    void findByField() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        List<Book> books = bookDao.findByField("price", "88.8");
        assertEquals(2, books.size());
        log.info("****************根据价格查询*****************");
        books.forEach(item -> log.info(String.valueOf(item)));
    }

    @Test
    void update() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        Book updateBook = new Book(1L,"1001","修改书名",1000.5,LocalDate.of(2021,11,13));
        bookDao.update(updateBook,1L);
        assertEquals(1000.5,((List<Book>) DataContext.getData()).get(0).getPrice());
        assertEquals("修改书名",((List<Book>) DataContext.getData()).get(0).getName());
        log.info("***********************修改********************");
        printData();

    }

    @Test
    void findAll() {
        init();
        BookDao<Book> bookDao = new BookDaoImpl();
        List<Book> books = bookDao.findAll();
        assertEquals(3, books.size());
        log.info("************查询所有数据**********");
        books.forEach(item -> log.info(String.valueOf(item)));
    }
}