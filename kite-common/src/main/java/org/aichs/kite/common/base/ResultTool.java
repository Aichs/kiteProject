package org.aichs.kite.common.base;

import org.aichs.kite.common.enums.ResultCode;

/**
 * @ClassName : ResultTool
 * @Description : 返回体构造工具
 * @Author : Kite
 * @Date: 2020-02-15 20:49
 */
public class ResultTool {

    public static JsonResult success() {
        return new JsonResult(true);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult(true, data);
    }

    public static JsonResult fail() {
        return new JsonResult(false);
    }

    public static JsonResult fail(ResultCode resultEnum) {
        return new JsonResult(false, resultEnum);
    }
}
