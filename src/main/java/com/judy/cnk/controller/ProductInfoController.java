package com.judy.cnk.controller;

import com.judy.cnk.Empty.ProductInfo;
import com.judy.cnk.Vo.result;
import com.judy.cnk.service.ProductInfoService;
import com.judy.cnk.util.resultUtil;
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
    public result insert(@RequestBody  ProductInfo productInfo){
        if (productInfo == null) {
            return resultUtil.file();
        }
        ProductInfo productInfoInsert = productInfoService.insert(productInfo);
        return resultUtil.sucssess(productInfoInsert);
    }

    /***
     *  扣减库存
     * @param productId 商品id
     * @param num 商品数量
     * @return
     */
    @GetMapping("/reduce")
    public result reduce(@RequestParam("productId") Integer productId,@RequestParam("num") Integer num){
        if (productId == null || num == null) {
            return resultUtil.file();
        }
        boolean reduce = productInfoService.reduce(productId, num);
        return resultUtil.sucssess(reduce);
    }
}
