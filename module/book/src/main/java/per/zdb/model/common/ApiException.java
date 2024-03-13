package per.zdb.model.common;

import lombok.Data;

/**
 * @Description: 接口异常
 * @author: Adobe Chow
 * @date: 2019/4/23 14:17
 * @Copyright: www.winshang.com Inc. All rights reserved.
 */
@Data
public class ApiException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String msg;//错误消息
    private int code;//错误代码
    private Object data;//错误数据

    private ApiException(){
        super();
    }

    public ApiException(String msg) {
        super(msg);
        this.msg = msg;
        this.code = -1819;
        this.data = null;
    }

    public ApiException(int code,String msg,Object data) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ApiException(int code,String msg) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.data=null;
    }

    public ApiException(Exception e){
        super(e.getMessage());
        if(e instanceof ApiException){
            ApiException self = (ApiException) e;
            this.msg = self.getMsg();
        }else{
            this.msg = e.getMessage();
        }

    }

}
