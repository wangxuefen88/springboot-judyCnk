package com.judy.cnk.Dao;

import com.judy.cnk.Empty.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: judy
 * @Description:
 * @Date: Created in 23:25 2019/1/19
 */
@Component
public interface ProductInfoDao extends JpaRepository<ProductInfo,Integer> {
}
