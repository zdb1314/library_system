package per.zdb.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import per.zdb.model.common.ApiException;
import per.zdb.model.vo.ResponseVo;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理类
 * @author: Adobe Chow
 * @date: 2019/4/16 18:07
 * @Copyright: www.winshang.com Inc. All rights reserved.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private  Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



    /**
     * 接口异常
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ResponseVo validateException(HttpServletRequest request,
                                  ApiException exception) throws Exception{
        exception.printStackTrace();
        logger.error("validateException===>",exception);
        return ResponseVo.create(exception.getCode(),exception.getMsg(),exception.getData());
    }

    /**
     * 全局异常
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseVo globeException(Exception exception) throws Exception{
        logger.error("接口报错",exception);
        exception.printStackTrace();
        logger.error("globeException===>",exception);
        return ResponseVo.create(-1912,"系统异常","接口报错"+exception.getMessage());
    }

}
