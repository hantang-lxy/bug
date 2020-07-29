package com.bugmanager.module;

/**
 * @author 李雪阳
 * @version 1.0
 * @date 2020/7/29  22:58
 */
public enum ErrorInfo {
    ERROR_LOW(10, "文字错误"),
    ERROR_MIDDLE(20, "次要错误"),
    ERROR_SEVERITY(30, "严重错误");
    private Integer code;
    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ErrorInfo(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
