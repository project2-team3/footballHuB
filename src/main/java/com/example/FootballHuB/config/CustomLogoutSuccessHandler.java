package com.example.FootballHuB.config;

import lombok.extern.java.Log;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@Log
public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

    public CustomLogoutSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        HttpSession url = request.getSession();

//        HttpSession aa = request.getSession();
//        Enumeration<String> attributeNames = aa.getAttributeNames();
//        while (attributeNames.hasMoreElements()) {
//            String attributeName = attributeNames.nextElement();
//            Object attributeValue = url.getAttribute(attributeName);
//            System.out.println("Attribute Name: " + attributeName + ", Value: " + attributeValue);
//        }

        if (url != null) {
            String redirectUrl = (String) url.getAttribute("nowPage");
            System.out.println(redirectUrl);
            if (redirectUrl != null) {
                url.removeAttribute("nowPage");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onLogoutSuccess(request, response, authentication);
            }
        } else {
            super.onLogoutSuccess(request, response, authentication);
        }
    }

}