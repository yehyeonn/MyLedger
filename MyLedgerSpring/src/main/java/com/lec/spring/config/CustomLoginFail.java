package com.lec.spring.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;

public class CustomLoginFail implements AuthenticationFailureHandler {

    private final String DEFAULT_FAILURE_FORWARD_URL = "/user/loginError";
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errorMessage = null;

        if(exception instanceof BadCredentialsException || exception instanceof InternalAuthenticationServiceException) errorMessage = "아이디나 비밀번호가 맞지 않습니다.";
        else errorMessage = "알 수 없는 이유로 로그인에 실패했습니다. 관리자에게 문의하세요.";

        request.setAttribute("errorMessage", errorMessage);
        request.setAttribute("username", request.getParameter("username"));

        request.getRequestDispatcher(DEFAULT_FAILURE_FORWARD_URL).forward(request, response);
    }
}
