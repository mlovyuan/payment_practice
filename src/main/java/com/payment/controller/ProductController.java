package com.payment.controller;

import com.payment.entity.Product;
import com.payment.service.ProductService;
import com.payment.valueObject.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Api(tags = "商品管理")
@RestController
@RequestMapping("api/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @GetMapping("/test")
    @ApiOperation("點擊測試")
    public ResponseResult test() {
        return ResponseResult.ok().addtData("message", "hello").addtData("now", new Date());
    }

    @GetMapping("/list")
    public ResponseResult list() {
        List<Product> list = productService.list();
        return ResponseResult.ok().addtData("productList", list);
    }
}
