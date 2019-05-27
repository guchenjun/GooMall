package com.milen.interceptor;

import com.milen.model.vo.LocationModeVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("info")) {
            request.setAttribute("locationMode", new LocationModeVO("info"));
            return true;
        }
        if (requestURI.contains("order")) {
            request.setAttribute("locationMode", new LocationModeVO("order"));
            return true;
        }
        if (requestURI.contains("cart")) {
            request.setAttribute("locationMode", new LocationModeVO("cart"));
            return true;
        }
        if (requestURI.contains("favorites")) {
            request.setAttribute("locationMode", new LocationModeVO("favorites"));
            return true;
        }

        return false;
    }
}
