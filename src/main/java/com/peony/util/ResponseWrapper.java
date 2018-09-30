package com.peony.util;

public class ResponseWrapper {

    private String responseCode;
    private String responseStatus;
    private String responseDesc;

    public void setResponseCode(String responseCode){
        this.responseCode = responseCode;
    }

    public void setResponseStatus(String responseStatus){
        this.responseStatus = responseStatus;
    }

    public void setResponseDesc(String responseDesc){
        this.responseDesc = responseDesc;
    }

    public String getResponseCode(){
        return responseCode;
    }

    public String getResponseStatus(){
        return responseStatus;
    }

    public String getResponseDesc(){
        return responseDesc;
    }

    @Override
    public String toString(){
        return "ResponseWrapper:{" +
                " resultCode=" + getResponseCode() +
                " resultStatus=" + getResponseStatus() +
                " resultDesc=" + getResponseDesc() +
                " }";
    }
}
