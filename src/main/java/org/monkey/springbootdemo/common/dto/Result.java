package org.monkey.springbootdemo.common.dto;

import lombok.Data;
import org.monkey.springbootdemo.common.enums.CommonError;
import org.slf4j.MDC;

import java.io.Serializable;

/**
 * Result
 *
 * @author cc
 * @since 2024/8/20 9:18
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String requestId;
    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> ok(T data) {
        return ok(CommonError.OK.getCode(), CommonError.OK.getMsg(), data);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return ok(CommonError.OK.getCode(), msg, data);
    }

    public static <T> Result<T> ok(int code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setRequestId(MDC.get("requestId"));
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail(T data) {
        return fail(CommonError.FAIL.getCode(), CommonError.FAIL.getMsg(), data);
    }

    public static <T> Result<T> fail(String msg, T data) {
        return fail(CommonError.FAIL.getCode(), msg, data);
    }

    public static <T> Result<T> fail(int code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setRequestId(MDC.get("requestId"));
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
