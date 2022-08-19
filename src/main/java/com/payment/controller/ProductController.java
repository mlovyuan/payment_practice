package com.payment.controller;

import com.payment.valueObject.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Api(tags = "商品管理")
@RestController
@RequestMapping("api/product")
public class ProductController {

    @GetMapping("/test")
    @ApiOperation("點擊測試")
    public ResponseResult test() {
        return ResponseResult.ok().addtData("message","hello").addtData("now", new Date());
    }
}
