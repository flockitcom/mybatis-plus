package com.zq.exception;

public interface CommonException {

    String getCode();

    String getMessage();

    String getDate();

    CommonException setMessage(String message);

    CommonException setDate(String date);
}