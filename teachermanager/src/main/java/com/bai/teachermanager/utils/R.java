package com.bai.teachermanager.utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应结果集的处理
 */
@Data
@NoArgsConstructor
@ApiModel("全局统一返回结果")
public class R {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();


    /**
     * 当成功时返回信息
     * @return
     */
    public static R ok(){
        R r = new R();
         r.setSuccess(ResultCode.SUCCESS.getSuccess());
         r.setCode(ResultCode.SUCCESS.getCode());
         r.setMessage(ResultCode.SUCCESS.getMessage());
         return  r;
    }

    /*
    错误信息返回
     */
    public static R error(){
        R r = new R();
        r.setSuccess(ResultCode.UNKNOWN_REASON.getSuccess());
        r.setCode(ResultCode.UNKNOWN_REASON.getCode());
        r.setMessage(ResultCode.UNKNOWN_REASON.getMessage());
        return r;
    }

    public static R setResult(ResultCode resultCode) {
        R r = new R();
        r.setSuccess(resultCode.getSuccess());
        r.setCode(resultCode.getCode());
        r.setMessage(resultCode.getMessage());
        return r;
    }

    public R success(Boolean success) {
        this.success(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }


}
