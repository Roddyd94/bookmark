package net.roddyd.bookmark.controller;

import net.roddyd.bookmark.exception.GeneralException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler({Exception.class})
    public Object exceptionGeneral(GeneralException e) {
        logger.error("Exception: [" + e.getCode() + "] " + e.getMessage());
        e.printStackTrace();

        return "Error";
    }
}
