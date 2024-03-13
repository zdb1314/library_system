package per.zdb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import per.zdb.entity.Book;
import per.zdb.model.dto.BookDto;
import per.zdb.model.vo.ResponseVo;
import per.zdb.service.remote.BookRemoteService;
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
@Api(tags = "书籍管理")
public class BookController {

    @Autowired
    private BookRemoteService bookService;

    @ApiOperation(value = "获取书籍列表")
    @PostMapping("list")
    public ResponseVo<List<Book>> list(@RequestBody BookDto dto){
        return bookService.list(dto);
    }

    @ApiOperation(value = "删除书籍")
    @PostMapping("delete")
    public ResponseVo delete(@RequestBody BookDto dto){
        return bookService.delete(dto);
    }

    @ApiOperation(value = "获取数据详情")
    @GetMapping("get/{id}")
    public ResponseVo<Book> get(@PathVariable("id") Integer id){
        return bookService.get(id);
    }

    @ApiOperation(value = "更新书籍")
    @PostMapping("update")
    public ResponseVo update(@RequestBody Book dto){
        return bookService.update(dto);
    }

    @ApiOperation(value = "增加书籍")
    @PostMapping("add")
    public ResponseVo add(@RequestBody Book dto){
        return bookService.add(dto);
    }

}
