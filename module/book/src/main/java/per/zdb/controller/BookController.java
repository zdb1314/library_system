package per.zdb.controller;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import per.zdb.entity.Book;
import per.zdb.model.dto.BookDto;
import per.zdb.model.vo.ResponseVo;
import per.zdb.service.IBookService;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周多兵
 * @since 2024-03-13
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping("list")
    public ResponseVo<List<Book>> list(@RequestBody BookDto dto){
        LambdaQueryChainWrapper<Book> lambdaQuery = bookService.lambdaQuery();
        if (dto.getId()!=null){
            lambdaQuery.eq(Book::getId,dto.getId());
        }
        List<Book> list = lambdaQuery.list();
        return ResponseVo.success(list);
    }

    @PostMapping("delete")
    public ResponseVo delete(@RequestBody BookDto dto){
        bookService.removeById(dto.getId());
        return ResponseVo.success();
    }

    @GetMapping("get/{id}")
    public ResponseVo<Book> get(@PathVariable("id") Integer id){
        Book book = bookService.getById(id);
        return ResponseVo.success(book);
    }

    @PostMapping("update")
    public ResponseVo update(@RequestBody Book dto){
        bookService.updateById(dto);
        return ResponseVo.success();
    }

    @PostMapping("add")
    public ResponseVo add(@RequestBody Book dto){
        bookService.save(dto);
        return ResponseVo.success(dto);
    }



}
