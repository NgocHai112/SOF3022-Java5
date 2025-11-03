package com.example.ps43664java5.interceptor;

import jakarta.servlet.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
        //cho trường hợp có login
        HttpSession session = req.getSession();
        Object user = session.getAttribute("loginUser");
        if (user == null) {
            res.sendRedirect("/login");
            return false;
        }
        return true;
        // ---- Cho trường hợp ko làm login -----
//        String uri = req.getRequestURI();
//
//        // Cho phép vào trang danh sách
//        if (uri.equals("/user/index") || uri.equals("/user/search")) {
//            return true;
//        }
//
//        // Nếu request là /user/create, /user/update, /user/delete => chặn
//        if (uri.startsWith("/user/create") ||
//                uri.startsWith("/user/update") ||
//                uri.startsWith("/user/delete")) {
//
//            System.out.println("🚫 Interceptor chặn truy cập: " + uri);
//            res.sendError(HttpServletResponse.SC_FORBIDDEN, "Bạn không có quyền thực hiện thao tác này!");
//            return false;
//        }
//
//        return true;

    }
}
