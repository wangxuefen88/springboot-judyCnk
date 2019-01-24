package com.judy.cnk.util;

import com.judy.cnk.vo.Result;

/**

 * @Author: judy
 * @Description: 封装返回给前端固定格式
 * @Date: Created in 19:47 2019/1/20
 */
public class ResultUtil {
    /**
     *
     * @param data 返回数据
     * @return 成功
     */
    public static Result sucssess(Object data){
        Result Result = new Result();
        Result.setCode(0000);
        Result.setMessage("成功");
        Result.setData(data);
        return Result;
    }

    /**
     *
     * @return 返回失败
     */
    public static Result file(){
        Result Result = new Result();
        Result.setCode(1111);
        Result.setMessage("失败");
        return Result;
    }
}

