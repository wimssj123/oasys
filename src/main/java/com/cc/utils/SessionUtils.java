package com.cc.utils;

import org.apache.shiro.session.Session;

public class SessionUtils {
    private static Session session = null;
    public  static  final String LONG_USER = "user";


    public static Session getSession() {
        return session;
    }

    public static void setSession(Session session) {
        SessionUtils.session = session;
    }
}
