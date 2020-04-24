package com.colamooon.data.api.sleep.exception;

import com.colamooon.data.api.common.exception.ColaException;
import com.colamooon.data.api.common.exception.ErrorMessageCode;
import org.springframework.http.HttpStatus;

public class SleepNotFoundException extends ColaException {


    public SleepNotFoundException() {
        super("SleepNotFoundException", ErrorMessageCode.SLEEP_NOT_FOUND);
    }

    public SleepNotFoundException(String message) {
        super(message);
    }

    public SleepNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);

    }

    public SleepNotFoundException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message, httpStatus, errorMessagerCode);
    }

    public SleepNotFoundException(String message, ErrorMessageCode errorMessagerCode) {
        super(message, errorMessagerCode);
    }

    public SleepNotFoundException(ErrorMessageCode errorMessagerCode) {
        super(errorMessagerCode);

    }

}
