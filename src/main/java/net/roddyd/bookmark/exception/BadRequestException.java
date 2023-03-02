package net.roddyd.bookmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends GeneralException {
    public BadRequestException(Integer code, String msg) {
        super(code, msg);
    }

    public BadRequestException(Integer code, Throwable cause) {
        super(code, cause);
    }

    public BadRequestException(Integer code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
