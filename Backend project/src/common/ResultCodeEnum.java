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
    USERNAME_USED(503, "usernameUsed"),
    ADD_SCHEDULE_ERROR(504, "addScheduleError"),
    UPDATE_SCHEDULE_ERROR(505, "updateScheduleError"),
    DROP_SCHEDULE_ERROR(506, "dropScheduleError");

    private final Integer code;
    private final String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
