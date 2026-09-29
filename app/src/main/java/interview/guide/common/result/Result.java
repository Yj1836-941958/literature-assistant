package interview.guide.common.result;

import lombok.Getter;
import interview.guide.common.exception.ErrorCode;
import interview.guide.common.constant.CommonConstant;

@Getter
public class Result<T> {

    private final int code;
    private final String message;
    private final T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success() {
        return new Result(CommonConstant.StatusCode.SUCCESS, "请求成功", null);
    }

    public static <T> Result<T> success(T data) {
        return new Result(CommonConstant.StatusCode.SUCCESS, "请求成功", data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result(CommonConstant.StatusCode.SUCCESS, message, data);
    }

    public static <T> Result<T> error(ErrorCode errorCode) {
        return new Result(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> Result<T> error(String message) {
        return new Result(CommonConstant.StatusCode.BAD_REQUEST, message, null);
    }

    public static <T> Result<T> error(String message, T data) {
        return new Result(CommonConstant.StatusCode.BAD_REQUEST, message, data);
    }

    public boolean isSuccess() {
        return CommonConstant.StatusCode.SUCCESS == this.code;
    }
}
