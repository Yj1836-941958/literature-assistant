package interview.guide.common.log;

public class ErrorLogSanitizer {

    private ErrorLogSanitizer() {

    }

    /**
     * 仅输出异常类名，不输出可能携带的堆栈信息
     * **/
    public static String summerize(Exception e) {
        if (e == null) {
            return "unknown";
        }
        return e.getClass().getSimpleName();
    }

    /**
     * 将外部服务返回的自由文本归一为统一文本
     * **/
    public static String summerize(String message) {
        if (message == null || message.isBlank()) {
            return "";
        }
        return "external-error";
    }

    /**
     * 创建新的异常继承原始堆栈信息，可以定位问题，同时替换message,将cause设置为null,
     * 避免了message和caused by中可以泄露的敏感信息。
     * **/
    public static Throwable forLogger(Throwable error) {
        String errorType = error == null ? "unknown" : error.getClass().getSimpleName();
        SanitizedLogException sanitized = new SanitizedLogException(errorType);
        if (error != null) {
            sanitized.setStackTrace(error.getStackTrace());
        }
        return sanitized;
    }

    private static final class SanitizedLogException extends Exception {

        private SanitizedLogException(String errorType) {
            super("sanitized-error type="+errorType, null, false, true);
        }
    }
}
