package org.twave.controller.exception.sqlException;

/**
 * 锁被占用异常
 *
 * @author : twave
 * @date : 2023/7/24 15:46
 */
public class InsertTaskException extends RuntimeException {
    public InsertTaskException() {
        super();
    }

    public InsertTaskException(String message) {
        super(message);
    }

    public InsertTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertTaskException(Throwable cause) {
        super(cause);
    }

    protected InsertTaskException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
