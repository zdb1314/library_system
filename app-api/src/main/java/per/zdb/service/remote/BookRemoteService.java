package per.zdb.service.remote;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import per.zdb.conf.ServiceNameConstants;
import per.zdb.entity.Book;
import per.zdb.model.dto.BookDto;
import per.zdb.model.vo.ResponseVo;

import java.util.List;

@FeignClient(contextId = "BookRemoteService", value = ServiceNameConstants.BOOK)
public interface BookRemoteService {


    @PostMapping("/book/list")
    public ResponseVo<List<Book>> list(@RequestBody BookDto dto);

    @PostMapping("/book/delete")
    public ResponseVo delete(@RequestBody BookDto dto);

    @GetMapping("/book/get/{id}")
    public ResponseVo<Book> get(@PathVariable("id") Integer id);

    @PostMapping("/book/update")
    public ResponseVo update(@RequestBody Book dto);

    @PostMapping("/book/add")
    public ResponseVo add(@RequestBody Book dto);


}
