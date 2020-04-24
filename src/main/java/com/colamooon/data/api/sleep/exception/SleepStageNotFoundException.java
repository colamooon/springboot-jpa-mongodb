package com.colamooon.data.api.sleep.exception;

import com.colamooon.data.api.common.exception.ColaException;
import com.colamooon.data.api.common.exception.ErrorMessageCode;
import org.springframework.http.HttpStatus;

public class SleepStageNotFoundException extends ColaException {


    public SleepStageNotFoundException() {
        super("SleepStageNotFoundException", ErrorMessageCode.SLEEPSTAGE_NOT_FOUND);
    }

    public SleepStageNotFoundException(String message) {
        super(message);
    }

    public SleepStageNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);

    }

    public SleepStageNotFoundException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message, httpStatus, errorMessagerCode);
    }

    public SleepStageNotFoundException(String message, ErrorMessageCode errorMessagerCode) {
        super(message, errorMessagerCode);
    }

    public SleepStageNotFoundException(ErrorMessageCode errorMessagerCode) {
        super(errorMessagerCode);

    }

}
