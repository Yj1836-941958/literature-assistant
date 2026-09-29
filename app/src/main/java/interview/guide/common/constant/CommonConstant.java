package interview.guide.common.constant;

public class CommonConstant {

    private CommonConstant() {}

    public static final class StatusCode {
        public static final int SUCCESS = 200;
        public static final int BAD_REQUEST = 400;
        public static final int UNAUTHORIZED = 401;
        public static final int FORBIDDEN = 403;
        public static final int NOT_FOUND = 404;
        public static final int METHOD_NOT_ALLOWED =405;
        public static final int CONFLICT = 409;

        private StatusCode() {}
    }
}
