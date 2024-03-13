package per.zdb.service.impl;

import per.zdb.entity.Book;
import per.zdb.mapper.BookMapper;
import per.zdb.service.IBookService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 周多兵
 * @since 2024-03-13
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

}
