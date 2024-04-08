package org.FinalBubble.common.config.exception;

import lombok.Data;
import org.FinalBubble.common.Result.ResultCodeEnum;

/**
 * ClassName: GuiguException
 * Package: org.FinalBubble.common.config.exception
 * Description:
 *
 * @Author 杨其睿
 * @Create 2024-04-08 17:46
 * @Version 1.0
 */
@Data
public class GuiguException extends RuntimeException {
    private Integer code;
    private String msg;

    public GuiguException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 接收枚举类型对象
     * @param resultCodeEnum
     */
    public GuiguException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.msg = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
