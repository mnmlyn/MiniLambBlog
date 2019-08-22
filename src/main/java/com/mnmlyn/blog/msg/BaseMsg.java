package com.mnmlyn.blog.msg;

import lombok.Getter;
import lombok.Setter;

/**
 * 基本的响应消息定义
 *
 * @author mnmlyn
 * @date 2020/3/26
 */
@Getter
@Setter
public class BaseMsg {
    private Integer code;
    private String message;
    private Object data;

    public BaseMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static BaseMsg success() {
        return new BaseMsg(200, "成功");
    }

    public static BaseMsg fail(int code, String msg) {
        return new BaseMsg(code, msg);
    }

    public static BaseMsg successWithData(Object o) {
        BaseMsg msg = BaseMsg.success();
        msg.setData(o);
        return msg;
    }
}
