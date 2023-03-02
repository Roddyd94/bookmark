package net.roddyd.bookmark.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GeneralException extends RuntimeException {
    private Integer code;

    public GeneralException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }
    public GeneralException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }
    public GeneralException(Integer code, String msg, Throwable cause) {
        super(msg, cause);
        this.code = code;
    }
}
