package org.aichs.kite.common.enums;

import lombok.Getter;

/**
 * @ProjectName: kite
 * @Package: org.aichs.kite.common.enums
 * @ClassName: ResultEnum
 * @Author: MECHREVO
 * @Description:
 * @Date: 2019/11/21 21:51
 */
@Getter
public enum ResultEnum {
    
    // http
    OK(200,"请求已经成功处理"),
    LOG_OUT(200,"登出成功"),
    CREATED(201,"请求已经成功处理，并创建了资源"),
    ACCEPTED(202,"请求已接受，等待执行"),
    NON_AUTHORITATIVE_INFORMATION(203,"请求已经成功处理，但是信息不是原始得"),
    NO_CONTENT(204,"请求已经成功处理，没有内容需要返回"),
    RESET_CONTENT(205,"请求已经处理，请重置视图"),
    PARTIAL_CONTENT(206, "部分Get请求已经成功处理"),
    MULTI_STATUS(207,"请求已经成功处理，将返回XML消息体"),
    ALREADY_REPORTED(208, "请求已经成功处理，一个DAV的绑定成员被前一个请求枚举，并且没有被再一次包括"),
    IM_USED(226, "请求已经成功处理，将响应一个或者多个实例"),
    MULTIPLE_CHOICES(300, "提供可供选择的回馈"),
    MOVED_PERMANENTLY(301, "请求的资源已经永久转移"),
    FOUND(302, "请重新发送请求"),
    SEE_OTHER(303, "请以Get方式请求另一个URI"),
    NOT_MODIFIED(304, "资源未改变"),
    USE_PROXY(305, "请通过Location域中的代理进行访问"),
    TEMPORARY_REDIRECT(307,"请求的资源临时从不同的URI响应请求"),
    RESUME_INCOMPLETE(308, "请求的资源已经永久转移"),

    BAD_REQUEST(400, "请求错误，请修正请求"),
    UNAUTHORIZED(401, "没有被授权或者授权已经失效"),
    PAYMENT_REQUIRED(402, "预留状态"),
    FORBIDDEN(403, "请求被理解，但是拒绝执行"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "请求方法不支持"),                         //get post put ...请求方法错误
    NOT_ACCEPTABLE(406, "请求的资源不满足请求者要求"),
    PROXY_AUTHENTICATION_REQUIRED(407, "请通过代理进行身份验证"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "请求冲突"),
    GONE(410, "请求的资源不可用"),
    LENGTH_REQUIRED(411, "Content-Length未定义"),
    PRECONDITION_FAILED(412, "不满足请求的先决条件"),
    REQUEST_ENTITY_TOO_LARGE(413, "请求发送的实体太大"),
    REQUEST_URI_TOO_LONG(414, "请求的URI超长"),

    UNSUPPORTED_MEDIA_TYPE(415,"请求发送的实体类型不受支持"),            //content-type不受支持

    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Range指定的范围与当前资源可用范围不一致"),
    EXPECTATION_FAILED(417, "请求头Expect中指定的预期内容无法被服务器满足"),
    UNPROCESSABLE_ENTITY(422, "请求格式正确，但是由于含有语义错误，无法响应"),
    LOCKED(423, "当前资源被锁定"),
    FAILED_DEPENDENCY(424, "由于之前的请求发生错误，导致当前请求失败"),
    UPGRADE_REQUIRED(426, "客户端需要切换到TLS1.0"),
    PRECONDITION_REQUIRED(428, "请求需要提供前置条件"),
    TOO_MANY_REQUESTS(429, "请求过多"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "请求头超大，拒绝请求"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),

    NOT_IMPLEMENTED(501, "服务器不支持当前请求的部分功能"),
    BAD_GATEWAY(502, "响应无效"),
    SERVICE_UNAVAILABLE(503, "服务器维护或者过载，拒绝服务"),
    GATEWAY_TIMEOUT(504, "上游服务器超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "不支持的HTTP版本"),
    VARIANT_ALSO_NEGOTIATES(506, "服务器内部配置错误"),
    INSUFFICIENT_STORAGE(507, "服务器无法完成存储请求所需的内容"),
    LOOP_DETECTED(508, "服务器处理请求时发现死循环"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "服务器达到带宽限制"),
    NOT_EXTENDED(510, "获取资源所需的策略没有被满足"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "需要进行网络授权"),

    //sys
    HTTP_UNKNOWN_CODE(10000, "http未知状态"),
    NOT_LOGIN(10001, "用户未登录或登录已过期，请重新登陆"),
    ERROR_REQUEST_PARAM(10002, "请求参数有误"),
    USER_NOT_EXIST(10003, "用户名或密码错误"),
    ERR_USER_NO_PASSWORD(10004, "密码修改失败"),
    FAILURE_UPLOAD_FILE(10005,"上传失败"),
    DEL_FILE(10006,"删除失败"),
    MSG_15(1015,"文章不存在"),


    //session
    SESSION_EXISTS(20001,"当前用户经登录"),
    SESSION_KICKOUT(20002,"您的账号已在其他地方登录，如果不是您本人操作，请及时修改密码"),

    //菜单
    PERS_ALREADY_EXIST(30001, "权限表示已存在");
    
    
    private Integer code;
    private String msg;
    
    ResultEnum (Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
