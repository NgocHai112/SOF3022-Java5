package com.example.test.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        String uri = req.getRequestURI();
        if (uri.startsWith("/flights")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("user") == null) {
                res.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }
}
