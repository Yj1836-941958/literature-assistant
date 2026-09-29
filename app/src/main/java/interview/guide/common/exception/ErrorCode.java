package interview.guide.common.exception;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    BAD_REQUEST(400, "请求参数错误"),
    UNAUTHORIZED(401, "鉴权未通过"),
    FORBIDDEN(403, "请求禁止"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许"),
    CONFLICT(409, "资源冲突"),
    INTERNAL_ERROR(500, "服务器内部出错");

    private final int code;
    private final String message;
}
