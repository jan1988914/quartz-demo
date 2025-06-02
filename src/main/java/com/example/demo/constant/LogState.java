package com.example.demo.constant;

public enum LogState {


    LOG_SUS(1, "成功"),
    LOG_FAIL(2, "失败");

    private int status;
    private String desc;

    LogState(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
