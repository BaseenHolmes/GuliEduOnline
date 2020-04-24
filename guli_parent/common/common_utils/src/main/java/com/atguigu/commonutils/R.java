package com.atguigu.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: R
 * @Description: TODO
 * @Author: Baseen
 * @Date: 2020/4/14 14:21
 **/
@Data
public class R {

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "是否成功")
    private Boolean succeed;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setCode(ResultCode.SUCCEED);
        r.setSucceed(true);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setCode(ResultCode.ERROR);
        r.setSucceed(false);
        r.setMessage("失败");
        return r;
    }

    public R data(String key,Object value){
        data.put(key,value);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R succeed(Boolean flag){
        this.setSucceed(flag);
        return this;
    }

}
