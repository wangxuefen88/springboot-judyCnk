package com.judy.cnk.Vo;

import lombok.Data;

/**
 *
 * @param <T> data
 */
@Data
 public class result<T>{
    private Integer code;
    private String message;
    private T data;
}