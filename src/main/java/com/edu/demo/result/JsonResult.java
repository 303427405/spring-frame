package com.xkeshi.market.common.entitis.result;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Created by xukai on 2017/2/24.
 */
public class JsonResult {

    @JsonProperty("code")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    protected String code;

    @JsonProperty("description")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    protected String description;

    @JsonProperty("result")
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    protected Object result;

    public JsonResult() {
        super();
    }

    public JsonResult(String description) {
        this.description = description;
    }

    public JsonResult(String code, String description) {
        super();
        this.code   = code;
        this.description = description;
    }

    public JsonResult(String description, Object result) {
        this.description = description;
        this.result = result;
    }

    public JsonResult(String code, String description, Object result) {
        this.code = code;
        this.description = description;
        this.result = result;
    }

    /**添加状态码：成功*/
    public JsonResult addSuccess(){
        this.code = "success";
        return  this;
    }
    /**添加状态码：标识失败*/
    public JsonResult addFailed(){
        this.code = "failed";
        return  this;
    }

    /** 设置返回数据对象*/
    public JsonResult addResult(Object result){
        this.result = result;
        return this;
    }

    /**返回成功*/
    public static JsonResult resultSuccess(Object result){
        return new JsonResult().addSuccess().addResult(result);
    }

    /**返回失败*/
    public static JsonResult resultFail(Object result){
        return new JsonResult().addFailed().addResult(result);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
