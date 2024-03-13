package per.zdb.model.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

public class MyWrapper<T> extends QueryWrapper<T> {

    public static <T> QueryWrapper create(){
        return  new <T>MyWrapper();
    }




}
