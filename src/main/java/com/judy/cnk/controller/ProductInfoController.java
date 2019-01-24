package com.judy.cnk.controller;

import com.judy.cnk.empty.ProductInfo;
import com.judy.cnk.vo.Result;
import com.judy.cnk.service.ProductInfoService;
import com.judy.cnk.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: judy
 * @Description:
 * @Date: Created in 23:22 2019/1/19
 */

@RestController
@RequestMapping("judy/product")
public class ProductInfoController {
    @Autowired
    private ProductInfoService productInfoService;

    /**
     * 添加商品
     * @param productInfo 商品信息
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody  ProductInfo productInfo){
        if (productInfo == null) {
            return ResultUtil.file();
        }
        ProductInfo productInfoInsert = productInfoService.insert(productInfo);
        return ResultUtil.sucssess(productInfoInsert);
    }

    /***
     *  扣减库存
     * @param productId 商品id
     * @param num 商品数量
     * @return
     */
    @GetMapping("/reduce")
    public Result reduce(@RequestParam("productId") Integer productId, @RequestParam("num") Integer num){
        if (productId == null || num == null) {
            return ResultUtil.file();
        }
        ProductInfo productInfo = productInfoService.reduce(productId, num);
        return ResultUtil.sucssess(productInfo);
    }

    /***
     *  查询商品
     * @param productId 商品id
     * @return
     */
    @GetMapping("/queryProduct")
    public Result queryProduct(@RequestParam("productId") Integer productId){
        if (productId == null) {
            return ResultUtil.file();
        }
        ProductInfo productInfo = productInfoService.queryProduct(productId);
        return ResultUtil.sucssess(productInfo);
    }
}
