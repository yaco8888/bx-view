package com.bx.portrait.utils.result;

/**
 * @ClassName ResultDataMsg
 */
public class ResultDataMsg<T> extends ResultMsg {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultDataMsg(Integer code, String flag, String message, T data) {
        super(code, flag, message);
        this.data = data;
    }

}
