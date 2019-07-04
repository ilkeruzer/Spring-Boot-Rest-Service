package com.ilkeruzer.ecommerce.model;

import java.util.HashMap;
import java.util.Map;

public class Result {

    public static final String CODE_SUCCESS = "200";
    public static final String CODE_RESULT = "201";

    private String status;
    private String detailMessage;
    private Map<String,Object> data;

    public Result() {}

    public Result(String status) {
        this.status = status;
    }

    public Result(String detailMessage,String status) {
        this.detailMessage = detailMessage;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public static Result createSuccessResult() {
        return new Result(CODE_SUCCESS);
    }

    public static Result createResult(String detailMessage) {return new Result(detailMessage,CODE_RESULT);}

    public static Result createSuccessResult(String detailMessage) {return new Result(detailMessage,CODE_SUCCESS);}

    public void addData(String key, Object object) {
        if (data == null) {
            data = new HashMap<>(0);
        }
        this.data.put(key, object);
    }
}
