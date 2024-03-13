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

    @Test
    public void add() {
        Book book = new Book();
        book.setTitle("time");
        book.setAuthor("Adobe Chow");
        book.setRemark("It teach you how to use your time.");
        bookService.save(book);
    }

    @Test
    public void delete() {
        bookService.removeById(1);
    }

    @Test
    public void update() {
        Book book = bookService.getById(1);
        book.setTitle("time update");
        bookService.updateById(book);
    }

    @Test
    public void get() {
        Book book = bookService.getById(1);
        System.out.println(book);
    }


}
