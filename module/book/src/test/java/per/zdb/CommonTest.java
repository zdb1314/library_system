package per.zdb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import per.zdb.entity.Book;
import per.zdb.service.IBookService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommonTest {

    @Autowired
    private IBookService bookService;

    /**
     * 测试新增功能
     */
    @Test
    public void add() {
        Book book = new Book();
        book.setTitle("time");
        book.setAuthor("Adobe Chow");
        book.setRemark("It teach you how to use your time.");
        bookService.save(book);
    }

    /**
     * 测试删除功能
     */
    @Test
    public void delete() {
        bookService.removeById(1);
    }

    /**
     * 测试更新功能
     */
    @Test
    public void update() {
        Book book = bookService.getById(1);
        book.setTitle("time update");
        bookService.updateById(book);
    }

    /**
     * 测试获取功能
     */
    @Test
    public void get() {
        Book book = bookService.getById(1);
        System.out.println(book);
    }


}
