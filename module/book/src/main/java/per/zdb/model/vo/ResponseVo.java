package per.zdb.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description:
 * @author: Adobe Chow
 * @date: 2019/1/31 15:11
 * @Copyright: www.winshang.com Inc. All rights reserved.
 */
@ApiModel(description = "通用返回体")
@Data
@AllArgsConstructor
public class ResponseVo<T>  {
    @ApiModelProperty(value = "返回码(默认0为成功)",example = "0")
    private Integer code;
    @ApiModelProperty(value = "返回消息",example = "返回消息")
    private String msg;
    @ApiModelProperty(value = "返回数据",example = "[]")
    private T data;

    public static <T>ResponseVo success() {
       return new ResponseVo(0,"操作成功",null);
    }

    public static <T>ResponseVo success(String msg, T data) {
       return new ResponseVo(0,msg,data);
    }

    public static <T>ResponseVo success(T data) {
       return new ResponseVo(0,"操作成功",data);
    }

    public static <T>ResponseVo fail(String msg) {
       return create(-1,msg);
    }

    public ResponseVo<T> data(T data){
        this.data = data;
        return this;
    }

    public static ResponseVo create(Integer code, String msg, Object data){
        return new ResponseVo(code,msg,data);
    }

    public static ResponseVo create(Integer code, String msg){
        return create(code,msg,null);
    }

    public static ResponseVo create(Integer code){
        return create(code,"success",null);
    }

}
