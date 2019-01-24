package com.judy.cnk.vo;

import lombok.Data;

/**
 *
 * @param <T> data
 */
@Data
 public class Result<T>{
    private Integer code;
    private String message;
    private T data;
}