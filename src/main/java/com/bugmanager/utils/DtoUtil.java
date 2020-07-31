package com.bugmanager.utils;

import com.bugmanager.module.Dto;
import org.apache.poi.ss.formula.functions.T;

/**
 * 数据传输对象工具
 *
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/30  19:03
 */
public class DtoUtil {
    /**
     * 成功
     */
    private static final boolean SUCCESS = true;
    /**
     * 失败
     */
    private static final boolean FAIL = false;
    /**
     * 成功状态码
     */
    private static final Integer SUCCESS_CODE = 0;
    /**
     * 失败状态码
     */
    private static final Integer FAIL_CODE = -1;

    /**
     * 返回success
     *
     * @return Dto<T>
     */
    public static Dto<T> returnSuccess() {
        Dto<T> dto = new Dto<>();
        dto.setSuccess(SUCCESS);
        dto.setCode(SUCCESS_CODE);
        return dto;
    }

    /**
     * 返回 success with massage
     *
     * @return Dto<T>
     */
    public static Dto<T> returnSuccess(String message) {
        Dto<T> dto = new Dto<>();
        dto.setSuccess(SUCCESS);
        dto.setCode(SUCCESS_CODE);
        dto.setMessage(message);
        return dto;
    }

    /**
     * 返回 success with massage and data
     *
     * @return Dto<T>
     */
    public static Dto<T> returnSuccess(String message, T data) {
        Dto<T> dto = new Dto<>();
        dto.setSuccess(SUCCESS);
        dto.setCode(SUCCESS_CODE);
        dto.setMessage(message);
        dto.setData(data);
        return dto;
    }

    /**
     * 返回fail
     *
     * @return Dto<T>
     */
    public static Dto<T> returnFail() {
        Dto<T> dto = new Dto<>();
        dto.setSuccess(FAIL);
        dto.setCode(FAIL_CODE);
        return dto;
    }

    /**
     * 返回 fail with massage
     *
     * @return Dto<T>
     */
    public static Dto<T> returnFail(String message) {
        Dto<T> dto = new Dto<>();
        dto.setSuccess(FAIL);
        dto.setCode(FAIL_CODE);
        dto.setMessage(message);
        return dto;
    }

    /**
     * 返回 fail with massage and data
     *
     * @return Dto<T>
     */
    public static Dto<T> returnFail(String message, T data) {
        Dto<T> dto = new Dto<>();
        dto.setSuccess(FAIL);
        dto.setCode(FAIL_CODE);
        dto.setMessage(message);
        dto.setData(data);
        return dto;
    }

}
