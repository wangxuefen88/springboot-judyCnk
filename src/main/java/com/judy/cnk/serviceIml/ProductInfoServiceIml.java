package com.judy.cnk.serviceIml;

import com.judy.cnk.dao.ProductInfoDao;
import com.judy.cnk.empty.ProductInfo;
import com.judy.cnk.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

/**
 * @Author: judy
 * @Description:
 * @Date: Created in 23:24 2019/1/19
 */
@Slf4j
@Service
public class ProductInfoServiceIml implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    /**
     * 添加商品
     * @param productInfo 商品信息
     * @return
     */
    @Override
    public ProductInfo insert(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }

    /***
     *  扣减库存
     * @param productId 商品id
     * @param num 商品数量
     * @return
     */

    @Override
    public synchronized ProductInfo reduce(int productId, int num) {
        //1查看是否有该商品
        //2更新库存商品数量,库存数量在可减范围之内
        ProductInfo productInfo = productInfoDao.findOne(productId);
        log.info("productInfo 库存"+productInfo.getProductStock());
        //判断是否有值
        if(productInfo!=null){
            //商品数量为0
            if(productInfo.getProductStock()==0){
                log.info("productId-{},商品数量为0");
                return null;
            }
            //商品数量大于库存数量
            if(productInfo.getProductStock() < num){
                log.warn("productId-{},商品数量大于库存数量");
                return null;
            }
            productInfo.setProductStock(productInfo.getProductStock()-num);
            ProductInfo productInfo1 = productInfoDao.save(productInfo);
            return productInfo1;
        }
        log.info("productId-{},没有此商品");
        return null;
    }
    /***
     *  查询商品
     * @param productId 商品id
     * @return
     */
    @Override
    public ProductInfo queryProduct(Integer productId) {
        return productInfoDao.findOne(productId);
    }
}
