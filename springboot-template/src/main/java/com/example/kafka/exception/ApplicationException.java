package com.example.kafka.exception;

import java.text.MessageFormat;

/**
 * 通用业务异常类
 */
public class ApplicationException extends RuntimeException{

    // 异常代码
    private ExceptionCodeSet errorCode;
    // 异常消息
    private String errorMessage;

    public ApplicationException(ExceptionCodeSet errorCode){
        super(errorCode.getExceptionMessageCn());
        this.errorCode = errorCode;
    }

    public ApplicationException(ExceptionCodeSet errorCode, Object... params){
        super(MessageFormat.format(errorCode.getExceptionMessageCn(), params));
        this.errorCode = errorCode;
    }

    public ApplicationException(ExceptionCodeSet errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public ApplicationException(ExceptionCodeSet errorCode, Throwable cause){
        super(errorCode.getExceptionMessageCn(), cause);
        this.errorCode = errorCode;
    }

    public ApplicationException(ExceptionCodeSet errorCode, String errorMessage, Throwable cause){
        super(errorMessage, cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ExceptionCodeSet getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ExceptionCodeSet errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
