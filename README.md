# springboot-judyCnk


项目框架
springboot
jpa
mysql


创建数据库sql语句

CREATE TABLE `product_info` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `category_type` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` decimal(10,0) DEFAULT NULL,
  `product_stock` int(255) DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

