package net.roddyd.bookmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalErrorException extends GeneralException {
    public InternalErrorException(Integer code, String msg) {
        super(code, msg);
    }

    public InternalErrorException(Integer code, Throwable cause) {
        super(code, cause);
    }

    public InternalErrorException(Integer code, String msg, Throwable cause) {
        super(code, msg, cause);
    }
}
