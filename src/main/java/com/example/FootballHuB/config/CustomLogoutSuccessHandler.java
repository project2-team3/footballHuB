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
        HttpSession url = request.getSession(true);
        System.out.println("====================ㅁ");
        System.out.println(url.getAttribute("nowPage"));
        System.out.println("====================");

        HttpSession aa = request.getSession();
        Enumeration<String> attributeNames = aa.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = url.getAttribute(attributeName);
            System.out.println("Attribute Name: " + attributeName + ", Value: " + attributeValue);
        }

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



//        System.out.println("==================");
//        if (previousPage != null) {
//            // 이전 페이지로 리다이렉트
//            System.out.println("11111111111111");
//            getRedirectStrategy().sendRedirect(request, response, previousPage);
//        } else {
//            // 이전 페이지 정보가 없을 경우 기본 리다이렉트 URL을 사용합니다.
//            System.out.println("222222222222222");
//            super.onLogoutSuccess(request, response, authentication);
//        }
    }
}