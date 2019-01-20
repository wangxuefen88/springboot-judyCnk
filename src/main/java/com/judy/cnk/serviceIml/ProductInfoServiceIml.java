package com.judy.cnk.serviceIml;

import com.judy.cnk.Dao.ProductInfoDao;
import com.judy.cnk.Empty.ProductInfo;
import com.judy.cnk.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: judy
 * @Description:
 * @Date: Created in 23:24 2019/1/19
 */
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
    public boolean reduce(int productId, int num) {
        //1查看是否有该商品
        //2更新库存商品数量,库存数量在可减范围之内
        Optional<ProductInfo> productInfoOptional = productInfoDao.findById(productId);
        //判断是否有值
        if(productInfoOptional.isPresent()){
            ProductInfo productInfo = productInfoOptional.get();
            //商品数量为0
            if(productInfo.getProductStock()==0){
                return false;
            }
            //商品数量大于库存数量
            if(productInfo.getProductStock() < num){
                return false;
            }
            productInfo.setProductStock(productInfo.getProductStock()-num);
            productInfoDao.save(productInfo);
            return true;
        }
        return false;
    }
}
