package org.FinalBubble.common.Result;

import lombok.Getter;

/**
 * ClassName: ResultCodeEnum
 * Package: org.FinalBubble.common.Result
 * Description: 统一返回结果状态信息类
 *
 * @Author 杨其睿
 * @Create 2024-04-08 12:11
 * @Version 1.0
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(201, "失败"),
    SERVICE_ERROR(2012, "服务异常"),
    DATA_ERROR(204, "数据异常"),

    LOGIN_AUTH(208, "未登录"),
    PERMISSION(209, "没有权限")
    ;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
