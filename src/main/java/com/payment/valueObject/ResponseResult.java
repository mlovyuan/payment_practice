package com.payment.valueObject;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResponseResult {
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public static ResponseResult ok() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(0);
        responseResult.setMessage("成功");
        return responseResult;
    }

    public static ResponseResult error() {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(-1);
        responseResult.setMessage("失敗");
        return responseResult;
    }

    public ResponseResult addtData(String kry, Object value){
        data.put(kry, value);
        return this;
    }
}
