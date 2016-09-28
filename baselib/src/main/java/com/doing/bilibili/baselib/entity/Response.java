package com.doing.bilibili.baselib.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Doing on 2016/9/9.
 *
 */
public class Response<T> {

    private static final String FIELD_CODE = "code";
    private static final String FIELD_DATA = "data";
    private static final String FIELD_RESULT = "result";
    private static final String FIELD_MESSAGE = "message";
    private static final String FIELD_LIST = "list";


    @SerializedName(FIELD_CODE)
    private int code;
    @SerializedName(FIELD_RESULT)
    private T result;
    @SerializedName(FIELD_DATA)
    private T data;
    @SerializedName(FIELD_LIST)
    private List<T> list;
    @SerializedName(FIELD_MESSAGE)
    private String message;

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
