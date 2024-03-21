package per.zdb;

import org.junit.Assert;
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
        book.setId(1);
        book.setTitle("孙子兵法");
        book.setAuthor("孙武");
        book.setRemark("是中国春秋时期一部古典的军事著作，也是现存最早的兵书。作者是孙武。");
        boolean ok = bookService.save(book);

        Assert.assertTrue("新增图书失败",ok);
    }

    /**
     * 测试删除功能
     */
    @Test
    public void delete() {
        boolean ok = bookService.removeById(1);

        Assert.assertTrue("删除图书失败",ok);
    }

    /**
     * 测试更新功能
     */
    @Test
    public void update() {
        Book book = bookService.lambdaQuery()
                .last(" limit 1")
                .one();
        Assert.assertNotNull("获取图书失败",book);

        book.setTitle(book.getTitle()+" update");

        boolean ok = bookService.updateById(book);

        Assert.assertTrue("修改图书失败",ok);
    }

    /**
     * 测试获取功能
     */
    @Test
    public void get() {
        Book book = bookService.lambdaQuery()
                .last(" limit 1")
                .one();
        Assert.assertNotNull("获取图书失败",book);
    }


}
