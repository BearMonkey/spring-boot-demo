package org.monkey.springbootdemo.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * GlobalException
 *
 * @author cc
 * @since 2024/10/15 16:11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GlobalException extends RuntimeException {
    private int code;

    public GlobalException(String message) {
        super(message);
        this.code = code;
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public GlobalException(int code, String message) {
        super(message);
        this.code = code;
    }

    public GlobalException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
