package com.bangnd.util.exception;

/**
 * 文件存储异常运行时处理类
 *
 * @author fantasy
 */

public class StorageException extends RuntimeException {

    private static final long serialVersionUID = 2430191988074222554L;

    public StorageException(String message) {

        super(message);

    }

    public StorageException(String message, Throwable cause) {

        super(message, cause);

    }

}