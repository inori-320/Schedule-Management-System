package common;

import lombok.Getter;

/**
 * @author lty
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    USERNAME_ERROR(501, "usernameError"),
    PASSWORD_ERROR(502, "passwordError"),
    USERNAME_USED(503, "usernameUsed");
    private final Integer code;
    private final String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
