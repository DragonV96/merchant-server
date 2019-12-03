package com.glw.platform.common.security;

/**
 * @author : glw
 * @date : 2019/11/29
 * @time : 15:25
 * @Description : 每个ThreadLocal单独存储对应线程所携带的 token 信息
 */
public class AccessContext {
    private static final ThreadLocal<String> token = new ThreadLocal<>();

    public static String getToken() {
        return token.get();
    }

    public static void setToken(String tokenStr) {
        token.set(tokenStr);
    }

    public static void clearAccessKey() {
        token.remove();
    }
}
