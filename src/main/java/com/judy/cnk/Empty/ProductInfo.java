package com.judy.cnk.Empty;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: judy
 * @Description: 商品详情
 * @Date: Created in 23:27 2019/1/19
 */
@Entity
@Table(name = "product_info")
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String categoryType;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private Integer productStatus;
}
