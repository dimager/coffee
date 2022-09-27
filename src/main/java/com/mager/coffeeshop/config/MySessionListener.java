package com.mager.coffeeshop.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MySessionListener implements HttpSessionListener {
    private static final Logger logger = LogManager.getLogger("OrderService");
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        this.log(se.getSession());
        HttpSessionListener.super.sessionDestroyed(se);
    }

    synchronized private void log(HttpSession session){
        logger.info("seession was delete " + session.getId());
    }

}
