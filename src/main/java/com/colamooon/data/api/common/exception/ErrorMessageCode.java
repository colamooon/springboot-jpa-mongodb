package com.colamooon.data.api.common.exception;

public enum ErrorMessageCode {

    SUCCESS(200000, "success"),
    ERROR(500000, "error"),

    AUTH_NOT_FOUND(500100, "auth.not.found"),
    ROLE_NOT_FOUND(500101, "role.not.found"),

    USERNAME_NOT_FOUND(500102, "username.not.found"),
    AUTHENTICATION_FAILED_EXCEPTION(500103, "authentication.failed.exception"),

    USERNAME_IS_REQUIRED(500200, "username.is.required"),
    PASSWORD_IS_REQUIRED(500201, "password.is.required"),
    CONFIRMPASSWORD_IS_REQUIRED(500202, "confirmpassword.is.required"),
    USERNAME_IS_ALREADY_EXISTS(500203, "username.is.already_exists"),
    USERNAME_PATTERN_IS_NOT_ALLOWED(500204, "username.pattern.is.not.allowed"),
    PASSWORD_PATTERN_IS_NOT_ALLOWED(500205, "user.password.pattern.is.not.allowed"),
    CONFIRMPASSWORD_PATTERN_IS_NOT_ALLOWED(500206, "user.confirmpassword.pattern.is.not.allowed"),
    PASSWORD_IS_NOT_EQUALS(500207, "user.password.is.not.equals"),
    AGREE_IS_REQUIRED(500208, "agree.is.required"),
    SNSID_IS_REQUIRED(500209, "snsid.is.required"),
    SNSTYPE_IS_REQUIRED(500210, "snstype.is.required"),
    SNSTYPE_IS_INCORRENT_EXCEPTION(500211, "snstype.is.incorrent.exception"),

    MEMBER_NOT_FOUND(500212, "member.not.found"),
    EMAILVERIFICATION_NOT_FOUND(500213, "emailverification.not.found"),
    EMAIL_IS_REQUIRED(500214, "email.is.required"),
    VERIFICATION_NUMBER_IS_REQUIRED(500215, "verification.number.is.required"),
    VERIFICATION_NUMBER_IS_NOT_MATCHED(500216, "verification.number.is.not.matched"),
    GENDER_IS_REQUIRED(500217, "gender.is.required"),
    BIRTHYEAR_IS_REQUIRED(500218, "birthyear.is.required"),


    SLEEP_NOT_FOUND(500300, "sleep.not.found"),
    SLEEPSTAGE_NOT_FOUND(500301, "sleepstage.not.found"),

    SAMPLE_NOT_FOUND(500900, "sample.not.found"),
    SAMPLE_IS_ALREADY_EXISTS(500901, "sample.is.already.exists"),
    SAMPLE_TITLE_IS_REQUIRED(500902, "sample.title.is.required"),


    DUMMY(900000, "Dummy");


    ErrorMessageCode(final int codeValue, final String messageCode) {
        this.codeValue = codeValue;
        this.responseValue = messageCode;
    }

    private int codeValue;
    private String defaultMessage;
    private String responseValue;

    public int getCode() {
        return codeValue;
    }


    public String getResponseValue() {
        return responseValue;
    }

}

