package com.ibagroup.dto;

/**
 * @author AleksandrovichK
 */
public class RestResponse {
    private Object data;
    private Boolean success = true;

    public RestResponse() {
        this.success = false;
    }

    public RestResponse(Object data) {
        this.data = data;
    }

    public RestResponse(Object data, Boolean success) {
        this.data = data;
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
