package com.bx.portrait.utils.result;

import java.io.Serializable;

/**
 * @ClassName ResultEntity
 */
public class ResultMsg implements Serializable {

    private static final long serialVersionUID = 2635002588308355785L;

    /**
     * 状态码： 1 成功 0 失败
     */
    private int code;

    /**
     * 状态信息：success 成功 error 失败
     */
    private String flag;

    /**
     * 提示信息
     */
    private String message;

    public ResultMsg(int code, String flag, String message) {
        this.code = code;
        this.flag = flag;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
