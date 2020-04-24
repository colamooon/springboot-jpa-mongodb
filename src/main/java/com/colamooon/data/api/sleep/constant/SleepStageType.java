package com.colamooon.data.api.sleep.constant;

public enum SleepStageType {
    STAGE_AWAKE(0) {
        @Override
        public String shout() {
            return "NOTYET";
        }

    },
    STAGE_LIGHT(1) {
        @Override
        public String shout() {
            return "DOING";
        }
    },
    STAGE_DEEP(2) {
        @Override
        public String shout() {
            return "DONE";
        }
    },
    STAGE_REM(4) {
        @Override
        public String shout() {
            return "DONE";
        }
    };

    private SleepStageType(final int codeValue) {
        this.codeValue = codeValue;
    }

    private int codeValue;

    public int getCode() {
        return codeValue;
    }

    public abstract String shout();

}
