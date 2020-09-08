package com.zq.exception;

public class FprException extends Exception implements CommonException {
    private final CommonException commonException;

    /**
     * 直接接收EmBusinessError的传参用于构造业务异常
     * @param commonException
     */
    public FprException(CommonException commonException) {
        //一定要调用super(),因为exception自身会有初始化机制
        super();
        this.commonException = commonException;
    }

    /**
     * 接受自定义message的方式构造业务异常
     * @param commonException
     * @param message
     */
    public FprException(CommonException commonException, String message) {
        super();
        this.commonException = commonException;
        this.commonException.setMessage(message);
        this.commonException.setDate(message);
    }

    /**
     * 接受自定义message,date的方式构造业务异常
     * @param commonException
     * @param message
     * @param date
     */
    public FprException(CommonException commonException, String message,String date) {
        super();
        this.commonException = commonException;
        this.commonException.setMessage(message);
        this.commonException.setDate(date);
    }

    @Override
    public String getCode() {
        return this.commonException.getCode();
    }

    @Override
    public String getMessage() {
        return this.commonException.getMessage();
    }

    @Override
    public CommonException setMessage(String message) {
        return this.commonException.setMessage(message);
    }

    @Override
    public String getDate() {
        return this.commonException.getDate();
    }

    @Override
    public CommonException setDate(String date) {
        return this.commonException.setDate(date);
    }
}
