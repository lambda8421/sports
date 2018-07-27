package com.mofei.sports.web.base;

public enum  BasketballMatchType {
    NORMAL(1),//常规赛
    PRESEASON(2),//季前赛
    PLAYOFF(3);//季后赛

    private int value;

    BasketballMatchType(int value) {
        this.value = value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static BasketballMatchType of(int value) {
        for (BasketballMatchType status : BasketballMatchType.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }
}
