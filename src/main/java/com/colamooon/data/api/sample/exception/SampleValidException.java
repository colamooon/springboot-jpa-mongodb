package com.colamooon.data.api.sample.exception;

import com.colamooon.data.api.common.exception.ColaException;
import com.colamooon.data.api.common.exception.ErrorMessageCode;
import org.springframework.http.HttpStatus;

public class SampleValidException extends ColaException {


    public SampleValidException() {
        super("SampleValidException");
    }

    public SampleValidException(String message) {
        super(message);
    }

    public SampleValidException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);

    }

    public SampleValidException(String message, HttpStatus httpStatus, ErrorMessageCode errorMessagerCode) {
        super(message, httpStatus, errorMessagerCode);
    }

    public SampleValidException(String message, ErrorMessageCode errorMessagerCode) {
        super(message, errorMessagerCode);
    }

    public SampleValidException(ErrorMessageCode errorMessagerCode) {
        super(errorMessagerCode);

    }

}
