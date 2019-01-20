package com.judy.cnk.util;

import com.judy.cnk.Vo.result;
import lombok.Data;

/**

 * @Author: judy
 * @Description: 封装返回给前端固定格式
 * @Date: Created in 19:47 2019/1/20
 */
public class resultUtil {
    /**
     *
     * @param data 返回数据
     * @return 成功
     */
    public static result sucssess(Object data){
        result result = new result();
        result.setCode(0000);
        result.setMessage("成功");
        result.setData(data);
        return result;
    }

    /**
     *
     * @return 返回失败
     */
    public static result file(){
        result result = new result();
        result.setCode(1111);
        result.setMessage("失败");
        return result;
    }
}

