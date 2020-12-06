package com.silklee.video.pattern.singleton;

public enum EnumSingleton {
    INSTANCE;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static <T> T getInstance() {
        return (T) INSTANCE;
    }


}
