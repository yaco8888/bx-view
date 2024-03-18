package com.bx.portrait.utils.result;

/**
 * @ClassName ResultUtils
 */
public class ResultUtils<T> {

    // 成功
    private final static int RETURN_STATUS_SUCCESS = 1;
    // 失败
    private final static int RETURN_STATUS_FAIL = 0;
    // 成功
    private final static String RETURN_SUCCESS = "success";
    // 失败
    private final static String RETURN_FAIL = "fail";

    private final static String MSG_OK = "ok";
    private final static String MSG_NOT_FOUND = "not found";


    /**
     * @return ResultEntity
     * @Description 返回成功
     */
    public static ResultMsg SUCCESS() {
        return new ResultMsg(RETURN_STATUS_SUCCESS, RETURN_SUCCESS, MSG_OK);
    }

    /**
     * @param data
     * @return ResultEntityData
     * @Description 返回成功并携带数据
     */
    public static <T> ResultMsg SUCCESS(T data) {
        return new ResultDataMsg<T>(RETURN_STATUS_SUCCESS, RETURN_SUCCESS, MSG_OK, data);
    }

    /**
     * @return ResultEntity
     * @Description 返回失败
     */
    public static <T> ResultMsg ERROR() {
        return new ResultMsg(RETURN_STATUS_FAIL, RETURN_FAIL, MSG_NOT_FOUND);
    }

    /**
     * @param msg
     * @return ResultEntity
     * @Description 返回失败
     */
    public static <T> ResultMsg ERROR(String msg) {
        ResultMsg res = ERROR();
        res.setMessage(msg);
        return res;
    }

}
