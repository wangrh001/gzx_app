package com.bangnd.framework.sys;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SysHttpSessionListener implements HttpSessionListener {

    public static int online = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        online++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }


}