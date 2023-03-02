package net.roddyd.bookmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends GeneralException {
    public ForbiddenException(Integer code, String msg) {
        super(code, msg);
    }

    public ForbiddenException(Integer code, Throwable cause) {
        super(code, cause);
    }

    public ForbiddenException(Integer code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
