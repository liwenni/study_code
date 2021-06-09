package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JSONResponse {
    //业务操作是否成功
    private Boolean success;// 用于前端解析响应
    //业务数据
    private Object data;
    //错误码
    private String code;
    //错误信息
    private String message;
}
