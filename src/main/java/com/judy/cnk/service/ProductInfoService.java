package com.judy.cnk.service;

import com.judy.cnk.Empty.ProductInfo;
import org.springframework.stereotype.Service;

/**
 * @Author: judy
 * @Description:
 * @Date: Created in 23:23 2019/1/19
 */
@Service
public interface ProductInfoService {
    ProductInfo insert(ProductInfo productInfo);
    boolean reduce(int productId,int num);
}
