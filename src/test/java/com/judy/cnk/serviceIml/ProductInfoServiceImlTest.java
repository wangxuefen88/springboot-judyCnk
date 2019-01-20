package com.judy.cnk.serviceIml;

import com.judy.cnk.Empty.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @Author: judy
 * @Description: 测试商品库存操作
 * @Date: Created in 20:22 2019/1/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImlTest {
    @Autowired
    private ProductInfoServiceIml productInfoServiceIml;
    @Test
    public void insert() throws Exception {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("蛋糕");
        productInfo.setCategoryType("甜品");
        productInfo.setProductStock(10);
        productInfo.setProductPrice(new BigDecimal(25));
        productInfo.setProductStatus(0);
        ProductInfo productInfo1 = productInfoServiceIml.insert(productInfo);
        System.out.println(productInfo1.toString());
    }

    @Test
    public void reduce() throws Exception {
        int productId = 1;
        int num= 1;
        assertTrue(productInfoServiceIml.reduce(productId, num));
    }

}