package com.judy.cnk.service;

import com.judy.cnk.empty.ProductInfo;
import org.springframework.stereotype.Service;

/**
 * @Author: judy
 * @Description:
 * @Date: Created in 23:23 2019/1/19
 */
@Service
public interface ProductInfoService {
    ProductInfo insert(ProductInfo productInfo);
    ProductInfo reduce(int productId,int num);
    ProductInfo queryProduct(Integer productId);
}
