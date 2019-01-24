package com.judy.cnk.serviceIml;

import com.judy.cnk.empty.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * @Author: judy
 * @Description: 测试商品库存操作
 * @Date: Created in 20:22 2019/1/20
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImlTest {
    @Autowired
    private ProductInfoServiceIml productInfoServiceIml;

    int count=1;
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
        productInfoServiceIml.reduce(productId, num);
    }

    /**
     * 压测1000个人同时购买商品,减库存,
     */
    @Test
    public void reduceProduct(){
        Executor executor = Executors.newFixedThreadPool(10);
        int productId = 1;
        for (int i = 0; i <1000 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("count is :"+count);
                     productInfoServiceIml.reduce(productId, count);
                }
            });
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ProductInfo productInfo = productInfoServiceIml.queryProduct(productId);
        assert(10000-1000==productInfo.getProductStock());
    }

}